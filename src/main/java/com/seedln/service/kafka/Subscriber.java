package com.seedln.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
public class Subscriber {
    private CountDownLatch latch = new CountDownLatch(10);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "activity", groupId = "boot")
    public void recieve(ConsumerRecord<?, ?> consumerRecord) {
        log.info("RECIEVED: " + consumerRecord.toString());
    }
}
