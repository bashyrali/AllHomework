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

    private JsonReader jsonReader = new JsonReader();
    private Users users = jsonReader.putUsersFromJson("src/users.json");
    private Books books = jsonReader.putBooksFromJson("src/books.json");
    private Book book;
    private User user;
    private ActiveUser activeUser;


    public LessonServer(String host, int port) throws IOException {

        super(host, port);

        registerGet("/books", this::booksHandler);
        registerPost("/books", this::bookPost);
        registerGet("/about_book",this::aboutBookHandler);

        registerGet("/users",this::usersMarkerSampleHandler);
        registerPost("/users", this::profilePost);
        registerGet("/profile", this::profileGet);

        registerGet("/register", this::loginGet);
        registerPost("/register",this::loginPost);

        registerGet("/login", this::authGet);
        registerPost("/login", this::authPost);
        registerGet("/user", this::userGet);
        registerPost("/user", this::userPost);

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

    protected void registerPost(String route, RouteHandler handler){
        getRoutes().put("POST " + route, handler);
    }


    private void authGet(HttpExchange exchange){
        Path path = makeFilePath("login.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void loginGet(HttpExchange exchange){
        Path path = makeFilePath("register.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }


    private void usersMarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "users.html",users);
    }

    private void aboutBookHandler(HttpExchange exchange) {
        renderTemplate(exchange, "about_book.html", book);
    }

    private void booksHandler(HttpExchange exchange) {
        renderTemplate(exchange, "books.html",books);
    }

    private void userGet(HttpExchange exchange){
        renderTemplate(exchange, "user.html", activeUser);
    }

    private void userPost(HttpExchange exchange){
        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        book = books.getBooks().stream()
                .filter(b -> b.getId()==Integer.parseInt(parsed.get("id")))
                .findAny().orElse(null);
        if (book == null) {
            redirect303(exchange, "/books");
        }
        activeUser.takeBook(book, activeUser.getUser());
        books = activeUser.getBooks();

        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getId() == activeUser.user.getId()){
                users.getUsers().set(i, activeUser.getUser());
            }
        }
        jsonReader.addBooksToJson(books,"books.json");
        jsonReader.addUsersToJson(users,"src/users.json");
        redirect303(exchange, "/about_book");

    }

    private void profileGet(HttpExchange exchange){
        renderTemplate(exchange,"profile.html", user);
    }

    private void profilePost(HttpExchange exchange){
        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        user = users.getUsers().stream()
                .filter(b -> b.getId()==Integer.parseInt(parsed.get("id")))
                .findAny().orElse(null);

        if (user == null) {
            redirect303(exchange, "/users");
        }

        redirect303(exchange, "/profile");
    }

    private void authPost(HttpExchange exchange){
        String cType = getContentType(exchange);
        String raw = getBody(exchange);

        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        JsonReader gson = new JsonReader();
        Users json = gson.putUsersFromJson("src/users.json");

        for (User user: json.getUsers()) {
            if(user.getEmail().equals(parsed.get("email")) && user.getPassword().equals(parsed.get("password"))){

                activeUser = new ActiveUser(user,books);
                redirect303(exchange,"/user");
                return;
            }
        }

        String msg = "<h3>Аутентификация не удалась!Попробуйте, Еще раз! <a href=\"/login\" >ЖМИ</a></h3>";

        try {
            sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookPost(HttpExchange exchange){
        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");
        book = books.getBooks().stream()
                .filter(b -> b.getId()==Integer.parseInt(parsed.get("id")))
                .findAny().orElse(null);

        if (book == null) {
            redirect303(exchange, "/books");
        }
        redirect303(exchange, "/about_book");
}


    private void loginPost(HttpExchange exchange){
        String cType = getContentType(exchange);
        String raw = getBody(exchange);
        Map<String,String> parsed = LessonServer.parseUrlEncoded(raw, "&");

        for (User user: users.getUsers()) {
            if(user.getName().equals(parsed.get("name")) || user.getName().equals(parsed.get("email"))){
                String data = "<h3><a href=\"/register\" >Регистрация не удалась Попробуйте Еще раз</a></h3>";
                try {
                    sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data.getBytes());
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        user = new User(users.getUsers().get(users.getUsers().size()-1).getId() + 1,parsed.get("name"),parsed.get("email"), parsed.get("password"));
        users.getUsers().add(user);
        System.out.println(users.getUsers().size());
        jsonReader.addUsersToJson(users, "src/users.json");
        redirect303(exchange,"/profile");
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            Template temp = freemarker.getTemplate(templateFile);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                temp.process(dataModel, writer);
                writer.flush();
                var data = stream.toByteArray();
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
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
