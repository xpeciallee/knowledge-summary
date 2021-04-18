package com.lyh.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOMTest {
    byte[] bytes=new byte[100*1024];
    public static void main(String[] args) throws InterruptedException {
            List<HeapOOMTest> list=new ArrayList<>();
            while(true){
                list.add(new HeapOOMTest());
                Thread.sleep(100);
            }

    }
}
