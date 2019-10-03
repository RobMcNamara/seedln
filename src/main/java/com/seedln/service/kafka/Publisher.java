package com.seedln.service.kafka;

import com.seedln.service.model.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class Publisher {
    @Autowired
    private KafkaTemplate<String, Activity> kafkaTemplate;

    public void send(String topic, Activity payload) {
        log.info("Sending payload: " + payload + " on topic: " + topic);
        ListenableFuture<SendResult<String, Activity>> result = kafkaTemplate.send(topic, "part1", payload);

        result.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("COULDN'T PUSH MESSAGE TO KAFKA: " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Activity> result) {
                log.info("Sent with result: " + result.getRecordMetadata());
            }
        });
    }
}
