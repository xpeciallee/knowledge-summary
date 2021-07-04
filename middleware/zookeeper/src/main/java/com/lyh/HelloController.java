package com.lyh;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoo")
public class HelloController {

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CuratorFramework client;

    @RequestMapping("" +
            "")
    public String hello() {
        final InterProcessMutex lock = new InterProcessMutex(client, "/lock");
        try {
            lock.acquire();
            log.info("{} 获取锁成功", Thread.currentThread().getName());
            System.out.println("执行业务逻辑。。。。");
            Thread.sleep(15 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            try {
                lock.release();
                log.info("{} 释放锁成功", Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "OK";
    }
}