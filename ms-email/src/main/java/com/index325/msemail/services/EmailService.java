package com.index325.msemail.services;

import com.index325.msemail.dtos.EmailDTO;
import com.index325.msemail.entities.Email;
import com.index325.msemail.repositories.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailDTO sendEmail(EmailDTO emailDTO) {

        Email email = new Email();

        BeanUtils.copyProperties(emailDTO, email);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("gabriel.index325@gmail.com");
            message.setTo(emailDTO.getEmail());
            message.setSubject("Microservice test");
            message.setText("Hello, " + emailDTO.getName() + "! \n If you're receiving this message, is because the microservice worked as expected");
            emailSender.send(message);

            email.setSent(true);
        } catch (MailException e) {
            email.setSent(false);
        } finally {
            return new EmailDTO(repository.save(email));
        }

    }
}
