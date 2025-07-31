package org.example.kafkaconsumer;

import org.example.common.TopicConstant;
import org.example.common.UserMessage;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = TopicConstant.TEST_TOPIC, groupId = "test-group")
    public void consumeStringMessage(String message, Acknowledgment ack) {
          System.out.println("收到字符串："+message);

          //手动提交偏移，表示消息已经处理完
          ack.acknowledge();

    }

    @KafkaListener(topics = TopicConstant.USER_TOPIC, groupId = "test-group")
    public void consumeUserMessage(UserMessage message, Acknowledgment ack) {
        System.out.println("收到用户消息："+message);

        //手动提交偏移，表示消息已经处理完
        ack.acknowledge();

    }
}
