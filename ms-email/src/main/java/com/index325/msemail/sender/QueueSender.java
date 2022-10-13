package com.index325.msemail.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.index325.msemail.services.exceptions.MessageCouldnotBeSent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String queueName, Object messageObj) {

        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            String stringifiedMessage = ow.writeValueAsString(messageObj);

            rabbitTemplate.convertAndSend(queueName, stringifiedMessage);
        } catch (JsonProcessingException e){
            throw new MessageCouldnotBeSent("The message couldn't be sent");
        }

    }
}