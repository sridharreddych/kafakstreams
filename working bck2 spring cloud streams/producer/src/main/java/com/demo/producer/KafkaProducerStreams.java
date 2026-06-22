package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {


    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {
        return () -> {
           RiderLocation riderLocation =  new RiderLocation("rider123",16.7,71.1);
            System.out.println("Sending Rider Location: " + riderLocation.getRiderId());
            return riderLocation;
        };
    }

}
