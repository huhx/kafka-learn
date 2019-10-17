package com.linux.huhx.kafka.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class KafkaMessage<T> {

  private T message;
  private Date dateTime;
}
