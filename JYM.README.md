# 架构概览
## QMQ中各组件:
* meta server提供集群管理和集群发现的作用
* server 提供实时消息服务
* delay server 提供延时/定时消息服务，延时消息先在delay server排队，时间到之后再发送给server
* producer 消息生产者
* consumer 消息消费者

## 各组件交互过程:
1. delay server 向meta server注册
2. 实时server 向meta server注册
3. producer在发送消息前需要询问meta server获取server list
4. meta server返回server list给producer(根据producer请求的消息类型返回不同的server list)
5. producer发送延时/定时消息
6. 延时时间已到，delay server将消息投递给实时server
7. producer发送实时消息
8. consumer需要拉取消息，在拉取之前向meta server获取server list(只会获取实时server的list)
9. meta server返回server list给consumer
10. consumer向实时server发起pull请求
11. 实时server将消息返回给consumer