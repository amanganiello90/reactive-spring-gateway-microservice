package com.github.amanganiello90.filter;

import java.util.Base64;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpRequest;

@Component
public class AddBasicAuthHeaderGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
  
  private static final String HEADER_KEY = "Authorization";
  private static final String BASIC_PREFIX = "Basic ";
  
  @Override
  public GatewayFilter apply(NameValueConfig config) {
    StringBuilder sbHeaderValue = new StringBuilder(BASIC_PREFIX);
    StringBuilder authCode = new StringBuilder(config.getName()).append(":").append(config.getValue());
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
