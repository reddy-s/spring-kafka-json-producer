package com.innovate.producer.controllers;

import com.innovate.producer.dto.BetEventDTO;
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
@RequestMapping(value = "/message")
public class KafkaBetEventDTOSenderController {

    private Logger log = LoggerFactory.getLogger(KafkaBetEventDTOSenderController.class);

    @Autowired
    private KafkaBetEventSenderService KafkaBetEventSenderService;

    @PostMapping(value = "/producer/{event}")
    public ResponseEntity<BetEventDTO> produceMessage(@PathVariable String event, @RequestBody BetEventDTO betEventDTO){
        KafkaBetEventSenderService.send(event, betEventDTO);
        return new ResponseEntity<BetEventDTO>(betEventDTO, HttpStatus.OK);
    }
}
