package com.acmeair;

import io.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class BookingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }
    
    @Configuration
    @Profile("SpringCloud")
    @EnableDiscoveryClient
    class ConsulServiceDiscoveryConfig {
        // Using the spring cloud discovery client to access the customer service
        // You can enable this feature by using the profile of SpringCloud
    }

    @Configuration
    @Profile("!SpringCloud")
    @EnableServiceComb
    class ServiceCombConfig {
        // Here we just enable ServiceComb by default
    }
}
