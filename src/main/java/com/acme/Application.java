package com.acme;

import org.springframework.fu.jafu.JafuApplication;

import static org.springframework.fu.jafu.Jafu.webApplication;
import static org.springframework.fu.jafu.web.WebFluxServerDsl.server;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class Application {

    private static JafuApplication app = webApplication(appConfig ->
            appConfig.enable(server(serverConfig -> serverConfig.router(
                    route -> route.GET("/", request -> ok().syncBody("Hello world!"))
            )))
    );

    public static void main (String[] args) {
        app.run(args);
    }
}