package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    //@Bean
    /* RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route((r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route((r)->r.path("/products/**").uri("lb://PRODUCT-SERVICE"))
                .build();
    }
    */

    // à chaque fois ce service recoit une requete regarde l'URL c'est la où tu va trouver le nom du microservice
    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties){
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient,properties);
    }
}
