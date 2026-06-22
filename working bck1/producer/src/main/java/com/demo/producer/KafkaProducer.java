package com.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(
            @RequestParam("riderId") String riderId,
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude) {
        // Create RiderLocation object from request parameters
        RiderLocation riderLocation = new RiderLocation(riderId, latitude, longitude);
        kafkaTemplate.send("my-topic-2", riderLocation);
        return "Message sent to Kafka topic : " + riderLocation.getRiderId();
    }
}
