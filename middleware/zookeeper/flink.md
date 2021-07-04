https://docs.confluent.io/platform/6.1.0/installation/installing_cp/zip-tar.html
```
curl -O http://packages.confluent.io/archive/6.1/confluent-community-6.1.0.tar.gz
tar xzf confluent-6.1.0.tar.gz
./bin/schema-registry-start -daemon ./etc/schema-registry/schema-registry.properties 
```
https://blog.csdn.net/weixin_44575542/article/details/88594773
./bin\flink.bat run -c com.zuoan.KafkaFlinkStream E:\gitsource\flink-kafka-sample\target\flink-kafka-sample-1.0-SNAPSHOT.jar test F:\result.txt
