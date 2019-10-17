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

  @GetMapping("/{key}/{message}")
  public KafkaMessage sendKafkaMessage(@PathVariable("key") String key, @PathVariable("message") String message) {
    return producerService.sendMessage(key, message);
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("key") String key, @RequestParam("message") String message) {
    this.producerService.sendMessage(key,message);
  }

}
