# Call-Log
电信通话记录查询，针对大数据阶段组件练习。

# 模块介绍
## call-log-producer
该模块主要是为了生产数据，和熟悉数据结构

## call-log-script
用于存放项目的所有模块的配置文件和脚本文件。


# 项目流程
## 生产数据
## 消费数据
当生产数据模块完成后，使用flume来实时获取数据，使用kafka来以消息队列的方式消费数据
到HBase中。
### kafka 部分
1. 启动zookeeper集群
```
zkServer.sh start 
```
2. 启动kafka集群
```
bin/kafka-server-start.sh config/server.properties &
```
3. 创建主题(并不一定需要启动kafka集群)
```
bin/kafka-topics.sh \
--zookeeper linux101:2181 \
--create \
--replication-factor 3 \
--partitions 3 \
--topic calllog

```
4. 查看主题
```
bin/kafka-topics.sh \
--zookeeper linux101:2181 \
--list
```

### flume 配置
1. 创建job文件
2. 启动job

## 数据分析
## 数据展示

# Bug
1. 文件汉字编码格式，汉字乱码
2. 每次插入一条数据后，文件自动删除，导致只是创建了文件，每次数据都被清除，最终数据为空
