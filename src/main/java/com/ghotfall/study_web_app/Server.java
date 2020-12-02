package com.ghotfall.study_web_app;

import static spark.Spark.*;

public class Server {
    private static int counter = 0;

    public static void main(String[] args) {
        get("/", (request, response) -> "Available routes:</br>" +
                "/hello/world</br>" +
                "/hello/:name</br>" +
                "/counter");

        path("/hello", () -> {
            get("/world", (request, response) -> "Hello world");
            get("/:name", (request, response) -> "You are welcome, " + request.params(":name"));
        });

        get("/counter", (request, response) -> "Counter has been updated. Current value: " + ++counter);

    }
}
