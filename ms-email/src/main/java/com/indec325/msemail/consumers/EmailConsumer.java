package com.indec325.msemail.consumers;

import com.indec325.msemail.dtos.EmailDTO;
import com.indec325.msemail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = {"${spring.rabbitmq.queue}"})
    public void listen(@Payload EmailDTO userDTO) {
        emailService.sendEmail(userDTO);
        System.out.println("E-mail sent");
    }

}
