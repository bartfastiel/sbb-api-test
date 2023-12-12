package com.example.sbbapitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SbbApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbbApiTestApplication.class, args);
    }

    @Bean
    WebClient defineWebClient() {
        return WebClient.builder().baseUrl("https://data.sbb.ch").build();
    }

}
