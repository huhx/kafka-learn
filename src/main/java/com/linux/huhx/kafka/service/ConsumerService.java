package com.linux.huhx.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

  @KafkaListener(topics = "topicName", groupId = "foo")
  public void listen(String message) {
    System.out.println("Received Messasge in group foo: " + message);
  }

  @KafkaListener(topics = "topicName", groupId = "foo")
  public void listenWithHeaders(
          @Payload String message,
          @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
    System.out.println(
            "Received Message: " + message + "from partition: " + partition);
  }

}
