package com.example.demo.services;

import com.example.demo.models.Mails;
import com.example.demo.repo.MailsDAO;
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

    @Autowired
    private MailsDAO mailsDAO;

    public void sendNotification(String sendTo, String comment) throws MailException {

//Благодарим юзера за фидбек
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setFrom("cviridov_ka@gkl-kemerovo.ru");
        simpleMailMessage.setSubject("Avaria.ru");
        simpleMailMessage.setText("Спасибо, что делаете наш сервис лучше!");
        javaMailSender.send(simpleMailMessage);
        try {
            mailsDAO.save(new Mails(sendTo));
        }
        catch (Exception e){
            System.out.println("Такая почта уже есть в базе данных!");
        }

//Отправляем его комментарий и его почту на свою почту
        SimpleMailMessage feedback = new SimpleMailMessage();
        feedback.setTo("cviridov_ka@gkl-kemerovo.ru");
        feedback.setFrom("cviridov_ka@gkl-kemerovo.ru");
        feedback.setSubject("Avaria.ru");
        feedback.setText(sendTo + " оставил комментарий: " + comment);
        javaMailSender.send(feedback);
    }

}
