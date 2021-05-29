package com.lyh.kafka.function;

import com.lyh.kafka.entity.User;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

public class UserProcess extends KeyedProcessFunction<String, User, User> {

   private  static OutputTag<User> processTag= new OutputTag<User>("Processing",TypeInformation.of(User.class));
    private  static OutputTag<User> errorTag= new OutputTag<User>("Error",TypeInformation.of(User.class));
    @Override
    public void processElement(User user, Context context, Collector<User> collector) throws Exception {
            if(((String)user.getName()).contains("hehe")){
                context.output(processTag,user);
            }else {
                context.output(errorTag,user);
            }
    }


}
