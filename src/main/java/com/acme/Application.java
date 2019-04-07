package com.acme;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.fu.jafu.ConfigurationDsl;
import org.springframework.fu.jafu.JafuApplication;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.function.Consumer;

import static org.springframework.fu.jafu.Jafu.reactiveWebApplication;
import static org.springframework.fu.jafu.webflux.WebFluxServerDsl.webFlux;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class Application {

    private static ApplicationContextInitializer<GenericApplicationContext> webFluxServer = webFlux(
            server -> server.router(route -> {
                route.GET("/", request -> ok().syncBody("Hello world!"));
            })
    );

    private static Consumer<ConfigurationDsl> webConf = handle -> handle.enable(webFluxServer);

    private static JafuApplication app = reactiveWebApplication(app ->
            app.enable(webConf)
    );

    public static void main (String[] args) {
        app.run(args);
    }
}