package org.example.kafkaproducer.service;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.admin.*;
import org.example.common.TopicConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Component
public class CreateTopicService {

    @Value("${spring.kafka.bootstrap-server}")
    private String bootstrapServers;

    /**
     * 应用启动后创建
     */
    @PostConstruct
    public void createTopic() {
          Properties props = new Properties();
          props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
          try (AdminClient adminClient = AdminClient.create(props)){

              ListTopicsOptions options = new ListTopicsOptions();
              options.listInternal(false); // 仅返回用户创建的 Topic
              ListTopicsResult res = adminClient.listTopics(options);
              Set<String> topiecs=res.names().get();
              List<NewTopic> topicList=new ArrayList<NewTopic>();
              if(topiecs.contains(TopicConstant.TEST_TOPIC)){
//                  adminClient.deleteTopics(Arrays.asList(TopicConstant.TEST_TOPIC));
//                  System.out.println("删除 "+TopicConstant.TEST_TOPIC+" 成功.");
              }else{
                  //创建Test_Topic
                  NewTopic testTopic = new NewTopic(TopicConstant.TEST_TOPIC, TopicConstant.PARTITIONS, TopicConstant.REPICATION_FACtor);
                  topicList.add(testTopic);
              }


              if(topiecs.contains(TopicConstant.USER_TOPIC)){
//                  adminClient.deleteTopics(Arrays.asList(TopicConstant.USER_TOPIC));
//                  System.out.println("删除 "+TopicConstant.USER_TOPIC+" 成功.");
              }else{
                  //创建User_Topic
                  NewTopic userTopic =new NewTopic(TopicConstant.USER_TOPIC, TopicConstant.PARTITIONS, TopicConstant.REPICATION_FACtor);
                  topicList.add(userTopic);
              }

              if(topicList.size()>0){
                  adminClient.createTopics(topicList).all().get();
                  System.out.println("Topic 创建成功.");
              }


          }catch (ExecutionException e) {
              throw new RuntimeException(e);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }

    }
}
