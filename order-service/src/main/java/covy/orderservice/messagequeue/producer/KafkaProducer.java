package covy.orderservice.messagequeue.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import covy.orderservice.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

  private KafkaTemplate kafkaTemplate;

  @Autowired
  public KafkaProducer(KafkaTemplate kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public OrderDto send(String topic, OrderDto orderDto) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = "";
    try {
      jsonInString = mapper.writeValueAsString(orderDto);
    } catch (JsonProcessingException ex) {
      ex.printStackTrace();
    }

    kafkaTemplate.send(topic, jsonInString);
    log.info("Kafka Producer sent data from the Order microservice : " + orderDto);

    return orderDto;
  }
}
