package org.example.kafkaproducer.service;

import jakarta.annotation.Resource;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.example.common.TopicConstant;
import org.example.common.UserMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProducerService {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendTestMessage(String message) {
//        ProducerRecord<String, Object> record = new ProducerRecord<>(TopicConstant.TEST_TOPIC, message);
//
//        kafkaTemplate.send(record).get();

        kafkaTemplate.send(TopicConstant.TEST_TOPIC, message);
    }

    public void sendUserMessage(UserMessage message) {
        kafkaTemplate.send(TopicConstant.USER_TOPIC, message);
    }

}
