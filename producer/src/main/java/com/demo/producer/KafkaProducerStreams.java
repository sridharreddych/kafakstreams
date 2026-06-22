package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {


    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {
        Random random = new Random();
        return () -> {
           String riderId = "riderId"+new Random().nextInt(20);
           RiderLocation riderLocation =  new RiderLocation(riderId,16.7,71.1);
            System.out.println("Sending Rider Location: " + riderLocation.getRiderId());
            return riderLocation;
        };
    }

//    @Bean
//    public Supplier<Message<String>> sendRiderStatus() {
//        Random random = new Random();
//        return () -> {
//            String riderId = "riderId"+new Random().nextInt(20);
//            String status = random.nextBoolean()? "ride Started" : "ride Completed";
//            System.out.println("Sending : " + status);
//            return MessageBuilder.withPayload(riderId + " - " + status)
//                    .setHeader(KafkaHeaders.KEY, riderId.getBytes())
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
//                    .build();
//        };
//    }


    @Bean
    public Supplier<RiderStatus> sendRiderStatus() {

        Random random = new Random();

        return () -> {
            String riderId = "riderId" + random.nextInt(20);
            String status = random.nextBoolean() ? "ride Started" : "ride Completed";

            System.out.println("Sending : " + riderId + " -> " + status);

            return new RiderStatus(riderId, status);
        };
    }

}
