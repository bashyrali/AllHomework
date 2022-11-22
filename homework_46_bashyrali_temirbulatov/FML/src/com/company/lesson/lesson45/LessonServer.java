package com.company.lesson.lesson45;

import com.company.lesson.server.RouteHandler;
import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import com.company.lesson.server.BasicServer;
import com.company.lesson.server.ContentType;
import com.company.lesson.server.ResponseCodes;


import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LessonServer extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();
    private Cat cat = new Cat("Cat");

    public LessonServer(String host, int port) throws IOException {
        super(host, port);
        registerGet("/profile", this::catSampleHandler);
        registerPost("/", this::loginPost);
    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("data"));

            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getQueryParams(HttpExchange exchange) {
        String query = exchange.getRequestURI().getQuery();
        return Objects.nonNull(query) ? query : "";
    }



    private void catSampleHandler(HttpExchange exchange){

        String queryParams = getQueryParams(exchange);
        Map<String, String> params = LessonServer.parseUrlEncoded(queryParams, "&");
        if (params.size() != 0) {

            cat.setAction(params.get("catAction"));
            cat.actionCat();
            cat.setAvatar();
        }
        renderTemplate(exchange, "profile.html", cat);


    }


    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            // загружаем шаблон из файла по имени.

            Template temp = freemarker.getTemplate(templateFile);



            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {


                temp.process(dataModel, writer);
                writer.flush();

                // получаем байтовый поток
                var data = stream.toByteArray();

                // отправляем результат клиенту
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }




    protected void registerPost(String route, RouteHandler handler){
        getRoutes().put("POST " + route, handler);
    }

    private void loginPost(HttpExchange exchange){

        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        this.cat = new Cat(parsed.get("name"));
        redirect303(exchange,"/profile");


    }

    public static String getContentType(HttpExchange exchange){
        return exchange.getRequestHeaders()
                .getOrDefault("Content-Type", List.of(""))
                .get(0);
    }
    protected String getBody(HttpExchange exchange){
        InputStream input = exchange.getRequestBody();
        Charset utf8 = StandardCharsets.UTF_8;
        InputStreamReader isr = new InputStreamReader(input, utf8);
        try(BufferedReader reader = new BufferedReader(isr)){
            return reader.lines().collect(Collectors.joining(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static Map<String,String> parseUrlEncoded(String rawLines, String delimeter){
        String[] pairs = rawLines.split(delimeter);
        Stream<Map.Entry<String, String>> stream = Arrays.stream(pairs)
                .map(LessonServer::decode)
                .filter(Optional::isPresent)
                .map(Optional::get);
        return stream.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

    }
    public static  Optional<Map.Entry<String, String>> decode(String kv){
        if (!kv.contains("=")){
            return Optional.empty();
        }
        String[] pair = kv.split("=");
        if(pair.length != 2){
            return Optional.empty();
        }
        Charset utf8 = StandardCharsets.UTF_8;
        String key = URLDecoder.decode(pair[0], utf8);
        String value = URLDecoder.decode(pair[1],utf8);
        return Optional.of(Map.entry(key, value));

    }
    protected void redirect303(HttpExchange exchange,
                               String path) {
        try {
            exchange.getResponseHeaders().add("Location", path);
            exchange.sendResponseHeaders(303, 0);
            exchange.getResponseBody().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
