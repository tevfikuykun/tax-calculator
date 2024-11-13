package com.example.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class Routing {
  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
    return routeLocatorBuilder.routes()
        .route("products", r->r.path("/products/**")
            .filters(f->f.stripPrefix(1))
            .uri("lb://product-service"))
        .build();
  }
}
