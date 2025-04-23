package covy.apigatewayservice.config;


import covy.apigatewayservice.config.GlobalFilter.Config;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-14
 */
public class GlobalFilter extends AbstractGatewayFilterFactory<Config> {

    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    public static class Config {
    }

}
