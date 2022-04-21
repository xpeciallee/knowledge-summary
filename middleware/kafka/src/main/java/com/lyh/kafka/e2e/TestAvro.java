/*
package com.lyh.kafka.e2e;

import com.lyh.kafka.entity.User;
import com.lyh.kafka.function.UserProcess;
import com.lyh.kafka.selector.UserSelector;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.formats.avro.registry.confluent.ConfluentRegistryAvroDeserializationSchema;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;


import java.util.Properties;

public class TestAvro {
    public static void main(String[] args) throws Exception {
        // parse input arguments
        final ParameterTool parameterTool = ParameterTool.fromArgs(args);
        UserSelector userSelector = new UserSelector();
//        if (parameterTool.getNumberOfParameters() < 6) {
//            System.out.println(
//                    "Missing parameters!\n"
//                            + "Usage: Kafka --input-topic <topic> --output-string-topic <topic> --output-avro-topic <topic> "
//                            + "--bootstrap.servers <kafka brokers> "
//                            + "--schema-registry-url <confluent schema registry> --group.id <some id>");
//            return;
//        }
        Properties config = new Properties();
        config.setProperty("bootstrap.servers", parameterTool.getRequired("bootstrap.servers"));
        config.setProperty("group.id", parameterTool.getRequired("group.id"));
        String schemaRegistryUrl = parameterTool.getRequired("schema-registry-url");

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        FlinkKafkaConsumer<User> userStream = new FlinkKafkaConsumer<>("topic1", ConfluentRegistryAvroDeserializationSchema.forSpecific(User.class, schemaRegistryUrl), config);
        FlinkKafkaConsumer<User> userStream2 = new FlinkKafkaConsumer<>("topic2", ConfluentRegistryAvroDeserializationSchema.forSpecific(User.class, schemaRegistryUrl), config);

        DataStreamSource<User> stream = env.addSource(userStream);
        SingleOutputStreamOperator<User> userSingleOutputStreamOperator = stream.keyBy(userSelector)
                .process(new UserProcess())
                .name("user Process 1")
                .uid("user Process 1");
        env.execute("Kafka Confluent Schema Registry AVRO Example");
    }
}
*/
