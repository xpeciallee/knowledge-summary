package com.lyh.autoex;

public class Test {
    public static void main(String[] args) {
        new DataFlow().setFilter(new RealFilter()).getInput().filterData();
    }
}
