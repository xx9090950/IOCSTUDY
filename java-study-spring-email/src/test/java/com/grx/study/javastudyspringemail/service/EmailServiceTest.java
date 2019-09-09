package com.grx.study.javastudyspringemail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
    @Resource
    EmailService helloService;

    @Test
    public void sayHello() {
        helloService.sayHello();
    }

    @Test
    public void senMail() {
        helloService.sendTextMail("xx9090950@gmail.com","hello","world");
    }
}