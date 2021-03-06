# 简介
Spring Cloud体系简单demo，目前集成eureka注册中心，Ribbon、Feign消费者负载均衡以及Ribbbon消费者Hystrix熔断
注:Spring Cloud依赖Spring Boot
## eureka-server
提供eureka注册中心服务(port:1001)
EurekaServer默认有两个缓存，一个是ReadWriteMap，另一个是ReadOnlyMap。有服务提供者注册服务或者维持心跳时时，会修改ReadWriteMap。当有服务调用者查询服务实例列表时，默认会从ReadOnlyMap读取（这个在原生Eureka可以配置，SpringCloud Eureka中不能配置，一定会启用ReadOnlyMap读取），这样可以减少ReadWriteMap读写锁的争用，增大吞吐量。EurekaServer定时把数据从ReadWriteMap更新到ReadOnlyMap中。 
### 定时剔除失效服务(默认服务端60s剔除间隔，客户端30s心跳、90s失效)
#### 服务端
关闭保护机制
eureka.server.enable-self-preservation=false
剔除失效服务间隔
eureka.server.eviction-interval-timer-in-ms=2000
#### 客户端(服务提供者、服务消费者皆为客户端)
Eureka客户端向服务端发送心跳的时间间隔，单位为秒（客户端告诉服务端自己会按照该规则）
eureka.instance.lease-renewal-interval-in-seconds =1
Eureka服务端在收到最后一次心跳之后等待的时间上限，单位为秒，超过则剔除（客户端告诉服务端按照此规则等待自己）
eureka.instance.lease-expiration-duration-in-seconds =2
## eureka-provider
服务提供者(测试负载均衡需要集群port:2001)
## eureka-consumer
服务消费者(port:3001)
### eureka-consumer-ribbon
通过Ribbon负载均衡的服务消费者(port:3002)
### eureka-consumer-feign
通过feign负载均衡的服务消费者(port:3003)
### eureka-consumer-ribbon-hystrix
通过Ribbon负载均衡，Hystrix熔断的服务消费者(port:3004)