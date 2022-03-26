https://logz.io/learn/complete-guide-elk-stack/
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


https://www.elastic.co/guide/en/elasticsearch/reference/7.10/index-mgmt.html


```
GET /

PUT personinfo
{
    "settings": {
        "number_of_shards": 1,
        "number_of_replicas": 0
      }
}

GET personinfo

GET *

#添加数据 会随机分配uuid
POST /personinfo/_doc/
{
    "title":"手机",
    "images":"http://image.jj.com/12479122.jpg",
    "price":2999.00
}

#自定义id
POST /personinfo/_doc/5
{
    "title":"华为手机",
    "images":"http://image.jj.com/12479122.jpg",
    "price":3999.00
}

#加副标题
POST /personinfo/_doc/6
{
    "title":"华为电视",
    "subTitle":"小米合作出品",
    "images":"http://image.jj.com/12479122.jpg",
    "price":1999.00
}

POST /personinfo/_doc/7
{
    "title":"OPPO手机",
    "subTitle":"华为合作出品",
    "images":"http://image.jj.com/12479122.jpg",
    "price":1899.00
}

#删除
DELETE /personinfo/_doc/SiUfxn8BPNLWx2z2U1xk


#查询全部
GET personinfo/_search
{
    "query":{
        "match_all":{}
    }
}


```


```
{
  "took" : 602,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 6,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "personinfo",
        "_type" : "_doc",
        "_id" : "SiUfxn8BPNLWx2z2U1xk",
        "_score" : 1.0,
        "_source" : {
          "title" : "手机",
          "images" : "http://image.jj.com/12479122.jpg",
          "price" : 2999.0
        }
      },
      {
        "_index" : "personinfo",
        "_type" : "_doc",
        "_id" : "5",
        "_score" : 1.0,
        "_source" : {
          "title" : "华为手机",
          "images" : "http://image.jj.com/12479122.jpg",
          "price" : 3999.0
        }
      },
      {
        "_index" : "personinfo",
        "_type" : "_doc",
        "_id" : "7",
        "_score" : 1.0,
        "_source" : {
          "title" : "OPPO手机",
          "subTitle" : "华为合作出品",
          "images" : "http://image.jj.com/12479122.jpg",
          "price" : 1899.0
        }
      },
      {
        "_index" : "personinfo",
        "_type" : "_doc",
        "_id" : "6",
        "_score" : 1.0,
        "_source" : {
          "title" : "华为电视",
          "subTitle" : "小米合作出品",
          "images" : "http://image.jj.com/12479122.jpg",
          "price" : 1999.0
        }
      },
      {
        "_index" : "personinfo",
        "_type" : "_doc",
        "_id" : "SyUkxn8BPNLWx2z211wM",
        "_score" : 1.0,
        "_source" : {
          "title" : "手机",
          "images" : "http://image.jj.com/12479122.jpg",
          "price" : 2999.0
        }
      },
      {
        "_index" : "personinfo",
        "_type" : "_doc",
        "_id" : "TCUkxn8BPNLWx2z25lyl",
        "_score" : 1.0,
        "_source" : {
          "title" : "手机",
          "images" : "http://image.jj.com/12479122.jpg",
          "price" : 2999.0
        }
      }
    ]
  }
}


```