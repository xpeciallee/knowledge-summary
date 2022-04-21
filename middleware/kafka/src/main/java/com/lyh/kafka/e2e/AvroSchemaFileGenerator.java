package com.lyh.kafka.e2e;

import org.apache.avro.reflect.ReflectData;

public class AvroSchemaFileGenerator {
    public static void main(String[] args) {

        System.out.println(ReflectData.get().getSchema(Payment.class));
    }
}
