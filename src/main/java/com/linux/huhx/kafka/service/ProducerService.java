package com.linux.huhx.kafka.service;

import com.linux.huhx.kafka.domain.KafkaMessage;
import com.linux.huhx.kafka.message.Message;
import java.util.Date;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import static com.linux.huhx.kafka.constant.Constant.TOPIC;

@Service
@Slf4j
public class ProducerService {

  @Resource
  private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

  public KafkaMessage sendMessage(String key, String message) {
    log.info(String.format("#### -> Producing message -> %s", message));
    KafkaMessage<Message> kafkaMessage = new KafkaMessage(new Message(message, "byte"), new Date());
    try {
      SendResult<String, KafkaMessage> sendResult = this.kafkaTemplate.send(TOPIC, key, kafkaMessage).get();
      log.info("send result = {}", sendResult.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return kafkaMessage;
  }
}
