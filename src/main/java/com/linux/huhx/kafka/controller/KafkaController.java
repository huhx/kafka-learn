package com.linux.huhx.kafka.controller;

import com.linux.huhx.kafka.domain.Customer;
import com.linux.huhx.kafka.domain.KafkaMessage;
import com.linux.huhx.kafka.service.ProducerService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

  @Resource
  private ProducerService producerService;

  @GetMapping("/{key}/{message}")
  public KafkaMessage sendKafkaMessage(@PathVariable("key") String key, @PathVariable("message") String message) {
    return producerService.sendMessage(key, message);
  }

  @PostMapping("/publish")
  public KafkaMessage sendKafkaMessageObject(@RequestBody Customer customer) {
    return producerService.sendObject(customer);
  }
}
