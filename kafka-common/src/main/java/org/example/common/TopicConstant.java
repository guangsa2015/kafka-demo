package org.example.common;

public class TopicConstant {
       public static final String TEST_TOPIC = "test_topic";
       public static final String USER_TOPIC = "user_topic";


       //分区数
       public static final int PARTITIONS = 3;
       // 副本因子（需小于等于 Kafka 集群节点数，单机环境设为 1）
       public static final short REPICATION_FACtor = 1;

}
