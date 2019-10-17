package com.linux.huhx.kafka.controller;

import com.linux.huhx.kafka.domain.KafkaMessage;
import com.linux.huhx.kafka.service.ProducerService;
import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

  @Resource
  private ProducerService producerService;

  @GetMapping("/1/{message}")
  public KafkaMessage sendKafkaMessage(@PathVariable("message") String message) {
    return producerService.sendMessage("1", message);
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(  @RequestParam("key") String key, @RequestParam("message") String message) {
    this.producerService.sendMessage(key,message);
  }

}
