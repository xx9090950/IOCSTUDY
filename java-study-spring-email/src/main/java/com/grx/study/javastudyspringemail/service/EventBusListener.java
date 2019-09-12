package com.grx.study.javastudyspringemail.service;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import com.grx.study.javastudyspringemail.model.req.HtmlEmailDTO;
import com.grx.study.javastudyspringemail.model.req.ImgEmailDTO;
import com.grx.study.javastudyspringemail.model.req.TextEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

@Service
public class EventBusListener {

    /**
     * 引入bean
     */
    @Autowired
    private AsyncEventBus asyncEventBus;

    @Autowired
    private EmailService emailService;

    /**
     * 注册服务类
     */
    @PostConstruct
    public void init(){
        asyncEventBus.register(this);
    }

    /**
     * 线程安全，消费 文本消息
     * @param textEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendTextMail(TextEmailDTO textEmailDTO){
        emailService.sendTextMail(
                textEmailDTO.getTo(),
                textEmailDTO.getSubject(),
                textEmailDTO.getContent()
        );
    }

    /**
     * 线程安全 消费 html消息
     * @param htmlEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendHtmlMail(HtmlEmailDTO htmlEmailDTO){
        try {
            emailService.sendHtmlMail(
                    htmlEmailDTO.getTo(),
                    htmlEmailDTO.getHtmlContent(),
                    htmlEmailDTO.getSubject()
            );
        } catch (MessagingException e) {
           // nothing to do
        }
    }

    /**
     * 线程安全 消费 图文消息
     * @param imgEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendImgMail(ImgEmailDTO imgEmailDTO){
        try {
            emailService.sendImgMail(
                    imgEmailDTO.getTo(),
                    imgEmailDTO.getImgContent(),
                    imgEmailDTO.getSubject(),
                    imgEmailDTO.getRscId(),
                    imgEmailDTO.getImgPath()
            );
        } catch (MessagingException e) {
            // nothing to do
        }
    }
}
