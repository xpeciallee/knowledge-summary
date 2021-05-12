package com.lyh.kafka.serialization;

import com.google.gson.Gson;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import java.io.IOException;
import java.nio.charset.Charset;

public class CommonSchema<T> implements DeserializationSchema<T>, SerializationSchema<T> {
    private static final Gson gson = new Gson();
    private  Class<T> clazz;
    public CommonSchema(Class<T> clazz){
        this.clazz=clazz;
    }

    @Override
    public T deserialize(byte[] bytes) throws IOException {
       return gson.fromJson(new String(bytes), clazz);
    }

    @Override
    public boolean isEndOfStream(T t) {
        return false;
    }

    @Override
    public byte[] serialize(T t) {
        return gson.toJson(t).getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public TypeInformation<T> getProducedType() {
        return TypeInformation.of(clazz);
    }
}
