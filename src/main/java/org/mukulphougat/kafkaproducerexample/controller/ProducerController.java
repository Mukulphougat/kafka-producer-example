package org.mukulphougat.kafkaproducerexample.controller;

import org.mukulphougat.kafkaproducerexample.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProducerController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "NewTopic";

    // Publish messages using the GetMapping
    @GetMapping("/publish/{message}")
    public ResponseEntity<ResponseDto> publishMessage(@PathVariable("message")
                                 final String message)
    {
        kafkaTemplate.send(TOPIC, message);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("200", "Message Published"));
    }
}
