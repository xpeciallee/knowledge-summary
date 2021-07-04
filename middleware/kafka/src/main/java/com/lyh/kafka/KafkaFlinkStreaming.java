package com.lyh.kafka;

import com.lyh.kafka.entity.User;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;

import java.util.Properties;

public class KafkaFlinkStreaming {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000); // 非常关键，一定要设置启动检查点！！
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "demo");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  //key 反序列化
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("auto.offset.reset", "latest"); //value 反序列化

        FlinkKafkaConsumer<String> consumer =new FlinkKafkaConsumer<String>(
                "demo",  //kafka topic 这里改成需要的kafka主题
                new SimpleStringSchema(),  // String 序列化
                props);
        FlinkKafkaConsumer<String> output =new FlinkKafkaConsumer<String>(
                "demo",  //kafka topic 这里改成需要的kafka主题
                new SimpleStringSchema(),  // String 序列化
                props);
        DataStreamSource<String> stream = env.addSource(consumer);
        stream.keyBy(new KeySelector<String, Object>() {
            @Override
            public Object getKey(String s) throws Exception {
                return s;
            }
        }).process(new ProcessFunction<String, Object>() {
            @Override
            public void processElement(String s, Context context, Collector<Object> collector) throws Exception {
                if(s.contains("hehe")){

                }
            }
        });

    }
}
