package com.lyh.kafka.selector;

import com.lyh.kafka.entity.User;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.util.OutputTag;

public class UserSelector implements KeySelector<User,String> {
    public static OutputTag<String> PROCESSING=new OutputTag<String>("Process");
    @Override
    public String getKey(User user) throws Exception {
        return (String) user.getName();
    }
}
