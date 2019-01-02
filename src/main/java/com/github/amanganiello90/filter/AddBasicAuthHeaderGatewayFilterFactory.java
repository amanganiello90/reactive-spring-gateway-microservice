package com.github.amanganiello90.filter;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpRequest;

@Component
public class AddBasicAuthHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
  
  private static final String HEADER_KEY = "Authorization";
  private static final String BASIC_PREFIX = "Basic ";
  
  @Value("${gateway.basic.auth.username:''}")
  private String basicUsername;
  
  @Value("${gateway.basic.auth.password:''}")
  private String basicPassword;
  
  @Override
  public GatewayFilter apply(Object config) {
    StringBuilder sbHeaderValue = new StringBuilder(BASIC_PREFIX);
    StringBuilder authCode = new StringBuilder(basicUsername).append(":").append(basicPassword);
    String authorizationH =
        sbHeaderValue.append(Base64.getEncoder().encodeToString(authCode.toString().getBytes())).toString();
    return (exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest().mutate()
          .headers(httpHeaders -> httpHeaders.set(HEADER_KEY, authorizationH))
          .build();
      
      return chain.filter(exchange.mutate().request(request).build());
    };
  }
  
}

