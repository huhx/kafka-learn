package com.linux.huhx.kafka.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerService {

  @Resource
  private KafkaTemplate<String, String> kafkaTemplate;

  public String sendMessage() throws Exception {
    for (int i = 0; i < 100; i++) {
      this.kafkaTemplate.send("test", String.valueOf(i)).get();
    }
    return "success";
  }

  public String sendMessageWithRandomTime() throws Exception {
    for (int i = 0; i < 100; i++) {
      this.kafkaTemplate.send("test", String.valueOf(i)).get();
      TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
    }
    return "success";
  }
}
