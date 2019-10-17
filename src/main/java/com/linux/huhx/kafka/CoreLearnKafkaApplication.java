package com.linux.huhx.kafka;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class CoreLearnKafkaApplication {

  public static Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(CoreLearnKafkaApplication.class, args);
  }

  private final CountDownLatch latch = new CountDownLatch(3);


  @KafkaListener(topics = "pricing", groupId = "foo")
  public void listen(ConsumerRecord<?, ?> cr) throws Exception {
    logger.info("-------" + cr.toString());
    latch.countDown();
  }
}
