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

POST /personinfo/_doc/
{
    "title":"小米手机",
    "images":"http://image.jj.com/12479122.jpg",
    "price":2999.00
}

POST /personinfo/_doc/
{
    "title":"超米手机",
    "images":"http://image.jj.com/12479122.jpg",
    "price":2899.00,
    "stock": 200,
    "saleable":true
}

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
#_index 文档所属索引名称
#_type 文档所属类型名
#_id 文档唯一 ID
#_score 文档相关性打分
#_source 文档 JSON 数据
#_version 文档版本信息
#其中 _type 文档所属类型名，需要关注版本不同之间区别：
#7.0 之前，一个索引可以设置多个 types
#7.0 开始，被 Deprecated 了。一个索引只能创建一个 type，值为 _doc


#求分词（“小米”，“手机”）的并集
GET personinfo/_search
{
  "query": {
    "match": {
      "title": "小米手机"
    }
  }
}

#求分词（“小米”，“手机”）的交集
GET personinfo/_search
{
  "query": {
    "match": {
      "title":{
        "query": "小米手机",
         "operator": "and"
      }
    }
  }
}

#求分词（“小米”，“手机”，“电视”）的交集,加最小匹配度
GET personinfo/_search
{
  "query": {
    "match": {
      "title":{
        "query": "小米手机电视",
         "minimum_should_match": "75%"
      }
    }
  }
}

#多字段查询
GET personinfo/_search
{
  "query": {
   "multi_match": {
     "query": "小米",
     "fields": ["title","subTitle"]
   }
  }
}

#词条匹配  词条不可分割的
#词条查询和多词条查询使用与一些对查询结果要求精确的数据，如价格等等
#添加了中文就查不到结果，似乎对中文的支持较差
GET personinfo/_search
{
  "query": {
    "term": {
      "price": {
        "value": "2899.00"
      }
    }
  }
}

#多词条匹配  词条不可分割的
#添加了中文就查不到结果，似乎对中文的支持较差
GET personinfo/_search
{
  "query": {
    "terms": {
      "price": [
        "2899",
        "2999"
      ]
    }
  }
}
#结果集过滤
GET personinfo/_search
{
  "query": {
   "multi_match": {
     "query": "小米",
     "fields": ["title","subTitle"]
   }
  }
  , "_source": ["title","price"]
}

#结果集过滤（包含指定字段第二种写法）
GET personinfo/_search
{
  "query": {
   "multi_match": {
     "query": "小米",
     "fields": ["title","subTitle"]
   }
  }
  , "_source": {
    "includes": ["price","title"]
  }
}

#结果集过滤(不包含指定字段)
GET personinfo/_search
{
  "query": {
   "multi_match": {
     "query": "小米",
     "fields": ["title","subTitle"]
   }
  }
  , "_source":{
    "excludes": "price"
  }
}

#布尔查询
#match:匹配查询
#must+must 求交集
#should+should 求并集
#mustnot 求非
#其他两个不演示
GET personinfo/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "title": "小米"
          }
        },{
          "terms": {
            "price": [
              "2999",
              "2699",
              "3899"            ]
          }
        }
      ]
    }
  }
}

#范围查询 
#gte 大于或大于等于  gt:大于
#lte 小于或小于等于  lt:小于
GET personinfo/_search
{
  "query": {
    "range": {
      "price": {
        "gte": 1999, 
        "lte": 2999   
      }
    }
  }
}

#模糊查询
#fuzziness 支持输入出最大错误数量 默认是0.5，最大是2
#添加了中文就查不到结果，似乎对中文的支持较差
GET personinfo/_search
{
  "query": {
    "fuzzy": {
      "title": {
        "value": "eppe"
        , "fuzziness": 2
      }
    }
  }
}

#过滤（不影响查询对象得分）
GET personinfo/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "title": "手机"
          }
        }
      ],"filter": [
        {
          "range": {
            "price": {
              "gte": 1999,
              "lte": 2999
            }
          }
        }
      ]
    }
  }
}

GET personinfo/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "title": "手机"
          }
        }
      ]
    }
  },"sort": [
    {
      "price": {
        "order": "desc"
      }
    }
  ]
}


#多字段排序（在价格相同的情况下再按id排序）
#降序是desc 升序是asc
GET personinfo/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "title": "手机"
          }
        }
      ]
    }
  },"sort": [
    {
      "price": {
        "order": "desc"
      }
    },
    {
      "_id":{
        "order": "desc"
      }
    }
  ]
}


#聚合

#创建测试索引
PUT cars
{
  "settings": {
    "number_of_shards": 1,
    "number_of_replicas": 0
  }
}


POST /cars/_bulk?pretty
{ "index": {}}
{ "price" : 10000, "color" : "red", "make" : "honda", "sold" : "2014-10-28" }
{ "index": {}}
{ "price" : 20000, "color" : "red", "make" : "honda", "sold" : "2014-11-05" }
{ "index": {}}
{ "price" : 30000, "color" : "green", "make" : "ford", "sold" : "2014-05-18" }
{ "index": {}}
{ "price" : 15000, "color" : "blue", "make" : "toyota", "sold" : "2014-07-02" }
{ "index": {}}
{ "price" : 12000, "color" : "green", "make" : "toyota", "sold" : "2014-08-19" }
{ "index": {}}
{ "price" : 20000, "color" : "red", "make" : "honda", "sold" : "2014-11-05" }
{ "index": {}}
{ "price" : 80000, "color" : "red", "make" : "bmw", "sold" : "2014-01-01" }
{ "index": {}}
{ "price" : 25000, "color" : "blue", "make" : "ford", "sold" : "2014-02-12" }

GET cars/_search

#添加映射
PUT cars/_mapping
{
  "properties": {
    "color": {
      "type": "keyword"
    },
    "make": {
      "type": "keyword"
    }
  }
}

DELETE cars


#根据颜色聚合
#aggs里第一个是聚合名称，随便写
#第二个是聚合类型，根据需求划分
#加size是设置结果集的数量
GET cars/_search
{
  "size": 0, 
  "aggs": {
    "popular_color": {
      "terms": {
        "field": "color"
      }
    }
  }
}

#计算每种颜色的平均价格，（嵌套度量）
GET cars/_search
{
  "size": 0, 
  "aggs": {
    "popular_color": {
      "terms": {
        "field": "color"
      },
      "aggs": {
        "price_avg": {
          "avg": {
            "field": "price"
          }
        }
      }
    }
  }
}

#计算每种颜色的平均价格及每种颜色的制造商(桶嵌套桶)
GET cars/_search
{
  "size": 0, 
  "aggs": {
    "popular_color": {
      "terms": {
        "field": "color"
      },
      "aggs": {
        "price_avg": {
          "avg": {
            "field": "price"
          }
        },
        "make":{
          "terms": {
            "field": "make"
          }
        }
      }
    }
  }
}

#阶梯分桶(没一价格段的商品数量)
#min_doc_count 设置最小数量的段才显示
GET cars/_search
{
  "size": 0
  , "aggs": {
    "price_ histogram": {
      "histogram": {
        "field": "price",
        "interval": 5000
        , "min_doc_count": 1
      }
    }
  }
}

```


