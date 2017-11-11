package com.innovate.producer.services.Abstracts;

import com.innovate.producer.services.interfaces.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by reddys on 10/11/2017.
 */
public abstract class KafkaEventSenderAbstract<T> implements Sender<String, T>{

    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;

    @Override
    public void send(String topic, T message) {
        kafkaTemplate.send(topic, message);
    }

}