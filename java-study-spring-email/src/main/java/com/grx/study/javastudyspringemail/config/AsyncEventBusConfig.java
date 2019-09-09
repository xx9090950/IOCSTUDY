package com.grx.study.javastudyspringemail.config;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class AsyncEventBusConfig {

    @Bean
    @Scope("singleton")
    public AsyncEventBus asyncEventBus(){
        final ThreadPoolExecutor executor=executor();
        return new AsyncEventBus(executor);
    }

    @Bean
    public ThreadPoolExecutor executor(){
        ThreadPoolExecutor executor=new
                ThreadPoolExecutor(2,
                2,0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>());
        return executor;
    }
}
