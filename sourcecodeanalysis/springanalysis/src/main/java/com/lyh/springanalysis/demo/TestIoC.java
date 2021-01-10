package com.lyh.springanalysis.demo;

import com.lyh.springanalysis.app.AppConfig;
import com.lyh.springanalysis.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIoC {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexService indexService = context.getBean(IndexService.class);
        indexService.sayHi();
    }
}
