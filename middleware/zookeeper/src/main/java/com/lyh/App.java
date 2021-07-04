package com.lyh;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CuratorFramework client() {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("1.116.113.7:2181")
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        client.start();
        return client;
    }
}
