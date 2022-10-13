package com.index325.msuser.consumers;

import com.index325.msuser.dtos.UserDTO;
import com.index325.msuser.services.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @Autowired
    UserService userService;

    @RabbitListener(queues = {"${spring.rabbitmq.queue}"})
    public void listen(@Payload UserDTO userDTO) {
        userService.createUser(userDTO);
        System.out.println("User created");
    }

}
