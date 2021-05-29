package com.lyh.kafka;

import com.lyh.kafka.entity.User;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

public class SchemaGenerator {
    public static void main(String[] args) {
        Schema schema = ReflectData.get().getSchema(User.class);
        System.out.println(schema);
    }
}
