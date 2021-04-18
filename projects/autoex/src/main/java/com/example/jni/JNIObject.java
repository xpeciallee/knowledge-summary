package com.example.jni;

public class JNIObject {
    private String name;
    static {
       // System.load("E:\\projects\\lee\\knowledge-summary\\jni\\libjni.dll");
        try{
            System.loadLibrary("libjni");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public JNIObject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int add(int param1, int param2) {
        return param1 + param2;
    }

    public int sub(int param1, int param2) {
        return param1 - param2;
    }

    public native int multi(int param1, int param2);

    public native int div(int param1, int param2);
}
