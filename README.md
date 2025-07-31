# kafka-demo

    基于 “发布 - 订阅” 模型，消息按主题（Topic） 分类，生产者向 Topic 写入消息，消费者从 Topic 读取消息。<br/>
    消息被分区（Partition）存储，支持分布式扩展，每个分区内消息有序（全局无序，除非单分区）。<br/>
    消息一旦写入，只能被追加（不可修改），通过偏移量（Offset）标记消费位置。<br/><br/>

Kafka本地调试demo,实现简单的收发消息，电脑要先启动zookeeper服务和kafka server。 <br/>
1、开发工具Intellij IDEA; <br/>
2、spring boot版本3.5.4, Kafka版本3.3.8; <br/>
3、通过SpringBootApplication注解类启动。
