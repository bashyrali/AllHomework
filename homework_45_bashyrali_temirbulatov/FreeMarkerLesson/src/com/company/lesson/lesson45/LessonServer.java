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
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LessonServer extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();
    private BooksCollection booksCollection = new BooksCollection();

    public LessonServer(String host, int port) throws IOException {
        super(host, port);
        registerGet("/books", this::booksmarkerSampleHandler);
        registerGet("/employee",this::employeeMarkerSampleHandler);
        registerGet("/about_book",this::aboutBooksmarkerSampleHandler);
        registerGet("/register", this::loginGet);
        registerPost("/register",this::loginPost);
        registerGet("/login", this::authGet);
        registerPost("/login", this::authPost);
        registerGet("/profile", this::authGet);



    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            // путь к каталогу в котором у нас хранятся шаблоны
            // это может быть совершенно другой путь, чем тот, откуда сервер берёт файлы
            // которые отправляет пользователю
            cfg.setDirectoryForTemplateLoading(new File("data"));

            // прочие стандартные настройки о них читать тут
            // https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html
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


    private void employeeMarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "employee.html", new EmployeesCollection() );
    }
    private void aboutBooksmarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "about_book.html", booksCollection);
    }
    private void booksmarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "books.html",booksCollection );
    }
    private void profileGet(HttpExchange exchange){
        renderTemplate(exchange,"profile.html", new Users());
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            // загружаем шаблон из файла по имени.
            // шаблон должен находится по пути, указанном в конфигурации
            Template temp = freemarker.getTemplate(templateFile);

            // freemarker записывает преобразованный шаблон в объект класса writer
            // а наш сервер отправляет клиенту массивы байт
            // по этому нам надо сделать "мост" между этими двумя системами

            // создаём поток который сохраняет всё, что в него будет записано в байтовый массив
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            // создаём объект, который умеет писать в поток и который подходит для freemarker
            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {

                // обрабатываем шаблон заполняя его данными из модели
                // и записываем результат в объект "записи"
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
    private void authGet(HttpExchange exchange){
        Path path = makeFilePath("login.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }
    private void loginGet(HttpExchange exchange){
        Path path = makeFilePath("register.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    protected void registerPost(String route, RouteHandler handler){
        getRoutes().put("POST " + route, handler);
    }

    private void authPost(HttpExchange exchange){
        String cType = getContentType(exchange);
        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        JsonReader gson = new JsonReader();
        Users json = gson.FromJson("src/Names.json");

        for (User user: json.getUsers()) {
            if(user.getEmail().equals(parsed.get("email")) && user.getPassword().equals(parsed.get("password"))){
                redirect303(exchange,"/profile.html");
                return;
            }
        }

        String fmt = "<h3>Аунтефикация не удалась Попробуйте Еще раз</h3>";

        try {
            sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, fmt.getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void loginPost(HttpExchange exchange){
        String cType = getContentType(exchange);
        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        JsonReader gson = new JsonReader();
        Users json = gson.FromJson("src/Names.json");
        for (User user: json.getUsers()) {
            if(user.getName().equals(parsed.get("name")) || user.getName().equals(parsed.get("email"))){
                String fmt = "<h3>регистрация не удалась Попробуйте Еще раз</h3>";
            String data  = String.format(fmt );
            try {
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data.getBytes());
                return;

            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
        User user = new User(parsed.get("name"),parsed.get("email"), parsed.get("password"));
        json.getUsers().add(user);
        gson.addToJson(json, "src/Names.json");
        redirect303(exchange,"/login");


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
    static  Optional<Map.Entry<String, String>> decode(String kv){
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
