package com.innovate.producer.controllers;

import com.innovate.producer.dto.BetEvent;
import com.innovate.producer.services.KafkaBetEventSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reddys on 10/11/2017.
 */
@RestController
@RequestMapping(value = "/message/")
public class KafkaStringSenderController {

    private Logger log = LoggerFactory.getLogger(KafkaStringSenderController.class);

    @Autowired
    private KafkaBetEventSenderService KafkaBetEventSenderService;

    @PostMapping(value = "/producer/{event}")
    public ResponseEntity<BetEvent> produceMessage(@PathVariable String event,@RequestBody BetEvent betEvent){
        log.info("Data Received topic: {}; message:{}", event, betEvent);
        KafkaBetEventSenderService.send(event, betEvent);
        return new ResponseEntity<BetEvent>(betEvent, HttpStatus.OK);
    }
}
