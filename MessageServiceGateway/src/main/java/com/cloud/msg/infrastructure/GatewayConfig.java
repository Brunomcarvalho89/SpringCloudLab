package com.cloud.msg.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 *
 * @author brunomcarvalho89@gmail.com
 */
@Configuration
public class GatewayConfig {

    @Autowired
    private PredicateLanguageMessage predicateLanguageMessage;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        RouteLocator build = builder.routes()
                .route("message-english",
                        r -> r.method(HttpMethod.GET)
                                .and()
                                .path("/message")
                                .and()
                                .predicate(this.predicateLanguageMessage.apply(LanguageMessage.ENGLISH))
                                .uri("lb://message-service-hello"))
                .route("message-portuguese",
                        r -> r.method(HttpMethod.GET)
                                .and()
                                .path("/message")
                                .and()
                                .predicate(this.predicateLanguageMessage.apply(LanguageMessage.PORTUGUESE))
                                .uri("lb://message-service-ola"))
                .build();

        return build;
    }
}
