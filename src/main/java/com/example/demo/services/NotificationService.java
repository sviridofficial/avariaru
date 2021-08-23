package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(String sendTo, String comment) throws MailException {

//Благодарим юзера за фидбек
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setFrom("cviridov_ka@gkl-kemerovo.ru");
        simpleMailMessage.setSubject("Avaria.ru");
        simpleMailMessage.setText("Спасибо, что делаете наш сервис лучше!");
        javaMailSender.send(simpleMailMessage);

//Отправляем его комментарий и его почту на свою почту
        SimpleMailMessage feedback = new SimpleMailMessage();
        feedback.setTo("cviridov_ka@gkl-kemerovo.ru");
        feedback.setFrom("cviridov_ka@gkl-kemerovo.ru");
        feedback.setSubject("Avaria.ru");
        feedback.setText(sendTo + " оставил комментарий: " + comment);
        javaMailSender.send(feedback);
    }

}
