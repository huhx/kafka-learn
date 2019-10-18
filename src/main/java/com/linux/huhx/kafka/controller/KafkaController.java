package com.linux.huhx.kafka.controller;

import com.linux.huhx.kafka.service.ProducerService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

  @Resource
  private ProducerService producerService;

  @GetMapping()
  public String sendKafkaMessage() throws Exception {
    return producerService.sendMessage();
  }

  @GetMapping("/random")
  public String sendMessageWithRandomTime() throws Exception {
    return producerService.sendMessageWithRandomTime();
  }
}
