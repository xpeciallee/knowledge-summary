package com.example.jni;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.getenv("env"));
        System.out.println(System.getProperty("name"));
        JNIObject jniObject = new JNIObject("jni");
        System.out.println(jniObject.getName()); // 调用java方法
        System.out.println(jniObject.add(1, 2)); // 调用java方法
        System.out.println(jniObject.sub(1, 2)); // 调用java方法
//        System.out.println(jniObject.multi(2, 3)); // 调用native方法
        System.out.println(jniObject.div(6, 2)); // 调用native方法
    }
}
