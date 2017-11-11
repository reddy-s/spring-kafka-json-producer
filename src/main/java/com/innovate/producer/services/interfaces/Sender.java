package com.innovate.producer.services.interfaces;

/**
 * Created by reddys on 10/11/2017.
 */
public interface Sender<K,V> {
    void send(K topic, V message);
}
