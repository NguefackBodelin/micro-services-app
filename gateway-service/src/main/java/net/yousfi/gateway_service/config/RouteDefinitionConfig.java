package net.yousfi.gateway_service.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteDefinitionConfig {

    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient client, DiscoveryLocatorProperties properties){
        return new DiscoveryClientRouteDefinitionLocator(client, properties);
    }
}
