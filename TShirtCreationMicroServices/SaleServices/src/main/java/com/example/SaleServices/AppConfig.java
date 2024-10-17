package com.example.SaleServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    private com.example.SaleServices.proto.TShirtProtoServiceGrpc.TShirtProtoServiceBlockingStub tshirtServiceStub;

    @Bean
    public com.example.SaleServices.proto.TShirtProtoServiceGrpc.TShirtProtoServiceBlockingStub tshirtServiceStub() {
        return tshirtServiceStub;
    }

}
