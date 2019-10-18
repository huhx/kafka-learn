package com.linux.huhx.kafka.service;

import com.linux.huhx.kafka.domain.KafkaMessage;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerService {

  @Resource
  private KafkaTemplate<String, String> kafkaTemplate;

  public KafkaMessage sendMessage() {
    try {
      for (int i = 0; i < 100; i++) {
        this.kafkaTemplate.send("test", String.valueOf(i)).get();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
