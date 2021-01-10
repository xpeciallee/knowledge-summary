package com.lyh.springanalysis.service.impl;


import com.lyh.springanalysis.service.IndexService;
import org.springframework.stereotype.Component;

@Component
public class IndexServiceImpl implements IndexService {

    public void sayHi(){
        System.out.println("Sai HI");
    }
}
