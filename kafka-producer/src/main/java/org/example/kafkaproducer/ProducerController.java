package org.example.kafkaproducer;

import jakarta.annotation.Resource;
import org.example.common.UserMessage;
import org.example.kafkaproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaserver")
public class ProducerController {

       @Resource
       private ProducerService producerService;

       /**
        * 发送文本内容
        * @param message
        * @return
        */
       @GetMapping("/send/{msg}")
       public String  sendMessage(@PathVariable("msg") String message) {
              producerService.sendTestMessage(message);
              return "success";
       }

       /**
        * 发送一对一消息
        * @param message
        * @return
        */
       @GetMapping("/send/user/{msg}")
       public String sendUserMessage(@PathVariable("msg") String message) {
              UserMessage messageObj = new UserMessage();
              messageObj.setId(123);
              messageObj.setName("userA");
              messageObj.setContent("{f:userA,t:userB,m:"+message+"}");

              producerService.sendUserMessage(messageObj);
              return "success";
       }
}
