package com.grx.study.javastudyspringemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sayHello() {
        System.out.println("Hello world");
    }

    public void sendTextMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);
        javaMailSender.send(simpleMailMessage);
    }


    public void sendHtmlMail(String to, String htmlContent, String subject) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setFrom(from);
        messageHelper.setText(htmlContent,true);
        javaMailSender.send(message);
    }

    public void sendImgMail(String to ,String imgContent,String subject,String rscId,String imgPath) throws MessagingException {
        MimeMessage message =javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setFrom(from);
        messageHelper.setText(imgContent,true);
        messageHelper.addInline(rscId,new File(imgPath));
        javaMailSender.send(message);
    }
}
