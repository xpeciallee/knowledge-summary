package com.lyh.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

import java.util.List;

public class TestDataSet {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env
                = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Integer> amounts = env.fromElements(1, 29, 40, 50);
        int threshold = 30;
        List<Integer> collect = amounts
                .filter(a -> a > threshold)
                .reduce((integer, t1) -> integer + t1)
                .collect();
        collect.forEach(System.out::println);
       // assertThat(collect.get(0)).isEqualTo(90);
    }
}
