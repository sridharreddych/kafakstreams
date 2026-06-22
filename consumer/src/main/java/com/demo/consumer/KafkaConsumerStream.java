package com.demo.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumerStream {

    @Bean
    public Consumer<RiderLocation> processRiderLocation() {
        return riderLocation -> {
            System.out.println("Received Rider Location: " + riderLocation.getRiderId() + " Latitude: " + riderLocation.getLatitude() + " Longitude: " + riderLocation.getLongitude());
        };
    }
}
