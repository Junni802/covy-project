package covy.apigatewayservice.filter;

import covy.apigatewayservice.filter.GlobalFilter.Config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-14
 */

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<Config> {

    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // Custom Pre Filter
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Global Filter baseMessage: {}", config.getBaseMessage());

            if (config.isPreLogger()) {
                log.info("Global Filter start: request id -> {}", config.getBaseMessage());
            }

            // Custom Post Filter
            // Mono는 spring 5에서 사용하며, 비동기 방식을 사용할 경우 사용한다
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    log.info("Global Filter end: response code -> {}", response.getStatusCode());
                }
            }));
        });
     }

     @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

}
