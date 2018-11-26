package com.acme;

import org.springframework.fu.jafu.ApplicationDsl;

import static org.springframework.fu.jafu.ApplicationDsl.application;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class Application {

    public static ApplicationDsl app = application(app ->
            app.server(server -> server.router(
                    route -> route.GET("/", request -> ok().syncBody("Hello world!"))
            ))
    );

    public static void main (String[] args) {
        app.run(args);
    }
}