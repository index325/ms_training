package com.indec325.msuser.services;

import com.indec325.msuser.dtos.UserDTO;
import com.indec325.msuser.entities.User;
import com.indec325.msuser.repositories.UserRepository;
import com.indec325.msuser.sender.QueueSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    QueueSender queueSender;

    @Value("${spring.rabbitmq.email.queue}")
    String emailQueue;

    public UserDTO createUser(UserDTO userDTO){

        User user = new User();

        BeanUtils.copyProperties(userDTO, user);

        queueSender.send(emailQueue, userDTO);

        return new UserDTO(repository.save(user));
    }
}
