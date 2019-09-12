package com.grx.study.javastudyspringemail.controller;

import com.google.common.eventbus.AsyncEventBus;
import com.grx.study.javastudyspringemail.model.req.HtmlEmailDTO;
import com.grx.study.javastudyspringemail.model.req.ImgEmailDTO;
import com.grx.study.javastudyspringemail.model.req.Request;
import com.grx.study.javastudyspringemail.model.req.TextEmailDTO;
import com.grx.study.javastudyspringemail.model.res.Result;
import com.grx.study.javastudyspringemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RequestMapping("/email")
@RestController
public class MailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private AsyncEventBus asyncEventBus;

    @RequestMapping(value = "/sendTextMail", method = RequestMethod.POST)
    public Result<Integer> sendTextMail(@RequestBody Request<TextEmailDTO> request) {
        Result<Integer> result = Result.create();
        asyncEventBus.post(request.getData());
        return result.success(1);
    }

    @RequestMapping(value = "/sendHtmlMail", method = RequestMethod.POST)
    public Result<Integer> sendHtmlMail(@RequestBody Request<HtmlEmailDTO> request) {
        Result<Integer> result = Result.create();
        asyncEventBus.post(request.getData());
        return result.success(1);
    }

    /**
     * 发送图文邮件
     * @param request
     * @return
     */
    @RequestMapping(value = "/sendImgMail", method = RequestMethod.POST)
    public Result<Integer> sendImgMail(@RequestBody Request<ImgEmailDTO> request) {
        Result<Integer> result = Result.create();
        ImgEmailDTO imgEmailDTO=request.getData();
        //组装一下content
        StringBuilder sb=new StringBuilder();
        sb.append(imgEmailDTO.getImgContent());
        //cid:资源id。在spring中会自动绑定
        sb.append("<img src=\'cid:").append(imgEmailDTO.getRscId()).append("\'></img>");
        imgEmailDTO.setImgContent(sb.toString());
        asyncEventBus.post(imgEmailDTO);
        return result.success(1);
    }

}
