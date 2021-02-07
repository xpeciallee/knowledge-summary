https://howtodoinjava.com/microservices/elk-stack-tutorial-example/#elk-stack

D:/Tools/googleDownload/elasticsearch-7.10.0-windows-x86_64/elasticsearch-7.10.0/bin
D:/Tools/googleDownload/kibana-7.10.0-windows-x86_64/bin
修改kibana.yml以指向elasticsearch实例。在我们的示例中，这将是9200。因此，请取消注释kibana.yml-中的以下行：
elasticsearch.url：“ http：// localhost：9200”

Let’s step through creating a simple config file and using it to run Logstash.
Create a file named "logstash-simple.conf" and save it in the same directory as Logstash.

input { stdin { } }
output {
elasticsearch { hosts => ["localhost:9200"] }
stdout { codec => rubydebug }
}

bin/logstash -f logstash-simple.conf

D:/Tools/googleDownload/logstash-7.10.0-windows-x86_64/logstash-7.10.0/bin

.\bin\logstash -f .\logstash-simple.conf


FATAL  Error: Start lifecycle of "beatsManagement" plugin wasn't completed in 30sec. Consider disabling the plugin and re-start.

curl -XPUT -H "Content-Type: application/json" http://localhost:9200/_all/_settings -d '{"index.blocks.read_only_allow_delete": null}'

PUT _cluster/settings
{
"transient": {
"cluster.routing.allocation.disk.watermark.low": "100gb",
"cluster.routing.allocation.disk.watermark.high": "50gb",
"cluster.routing.allocation.disk.watermark.flood_stage": "10gb",
"cluster.info.update.interval": "1m"
}
}

[error][data][elasticsearch] [version_conflict_engine_exception]: [task:apm-telemetry-task]: version conflict, document already exists (current version [1])

