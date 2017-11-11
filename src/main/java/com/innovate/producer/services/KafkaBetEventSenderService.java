package com.innovate.producer.services;

import com.innovate.producer.dto.BetEvent;
import com.innovate.producer.services.Abstracts.KafkaEventSenderAbstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by reddys on 10/11/2017.
 */
@Service
public class KafkaBetEventSenderService extends KafkaEventSenderAbstract<BetEvent> {

    private static final Logger log = LoggerFactory.getLogger(KafkaBetEventSenderService.class);

    @Override
    public void send(String topic, BetEvent message) {
        log.info("send data to topic {} : {}", topic, message.toString());
        super.send(topic, message);
    }
}
