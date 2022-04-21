package com.lyh.kafka;

import java.util.Properties;
import java.util.Random;

import com.lyh.kafka.e2e.Payment;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class ConfluentProducer {


    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put("bootstrap.servers", "1.116.113.7:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 使用Confluent实现的KafkaAvroSerializer
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        // 添加schema服务的地址，用于获取schema
        props.put("schema.registry.url", "http://1.116.113.7:8081");

        Producer<String, Payment> producer = new KafkaProducer<>(props);

//        Schema.Parser parser = new Schema.Parser();
//        Schema schema = parser.parse(USER_SCHEMA);
//
//        Random rand = new Random();
        int id = 0;

        while(id < 100) {
            id++;
            String name = "name" + id;
            Payment payment = new Payment();
            payment.setId(id);
            payment.setName(name);
            ProducerRecord<String, Payment> record = new ProducerRecord<>("test", payment);

            producer.send(record);
            Thread.sleep(1000);
        }

        producer.close();

    }

}
