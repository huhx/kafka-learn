package com.linux.huhx.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class CoreLearnKafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoreLearnKafkaApplication.class, args);
  }

  @KafkaListener(topics = "test", groupId = "huhx")
  public void listen(ConsumerRecord<String, String> consumerRecord) {
    log.info("value = " + consumerRecord.value());
  }
}
