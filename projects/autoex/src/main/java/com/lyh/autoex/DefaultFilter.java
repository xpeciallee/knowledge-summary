package com.lyh.autoex;

public abstract class DefaultFilter implements Filter{
    @Override
    public void filter() {
        System.out.println("Default Filter Data!!!");
    }
}
