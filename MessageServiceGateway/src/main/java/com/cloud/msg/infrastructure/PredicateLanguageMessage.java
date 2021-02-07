package com.cloud.msg.infrastructure;

import java.util.Objects;
import java.util.function.Predicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

/**
 *
 * @author brunomcarvalho89@gmail.com
 */
@Component
public class PredicateLanguageMessage extends AbstractRoutePredicateFactory<LanguageMessage> {

    public PredicateLanguageMessage() {
        super(LanguageMessage.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(LanguageMessage config) {

        return (ServerWebExchange exchange) -> {

            MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();

            String first = queryParams.getFirst("language");
            if (Objects.isNull(first)) {
                return Boolean.FALSE;
            }

            return first.equalsIgnoreCase(config.getLanguage());
        };
    }

}
