package org.jeecg.cloud.demo.lock;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.lock.annotation.DistributedLock;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.jeecg.boot.starter.rabbitmq.client.RabbitMqClient;
import org.jeecg.boot.starter.redis.client.JeecgRedisClient;
import org.jeecg.common.base.BaseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁测试demo
 * 2020/12/07 10:27:44
 */
@Slf4j
@Component
public class DemoLockTest {
    @Autowired
    RedissonLockClient redissonLock;

    @Autowired
    RabbitMqClient rabbitMqClient;

    @Autowired
    private JeecgRedisClient redisClient;

    /**
     * 这个demo进行测试队列的用法
     */
    @Scheduled(cron = "0/5 * * * * ?")
    @DistributedLock(lockKey = "redis-lock",expireSeconds = 11)
    public void myBus() throws InterruptedException{
        log.info("执行 myBus 开始 ，休眠3秒。。。");
        TimeUnit.SECONDS.sleep(3);
        BaseMap map = new BaseMap ();
        map.put("orderId", "123456");
        //发布、订阅
        rabbitMqClient.publishEvent("demoBusEvent", map);
    }


    /**
     * 这个demo进行测试队列的用法
     */
    //@Scheduled(cron = "0/5 * * * * ?")
    @DistributedLock(lockKey = "redis-lock",expireSeconds = 11)
    public void myExecute() throws InterruptedException{
        log.info("执行 myExecute 开始 ，休眠3秒。。。");
        TimeUnit.SECONDS.sleep(3);
        BaseMap map = new BaseMap ();
        map.put("orderId", "123456");
        redisClient.sendMessage("demoHandler", map);
    }

    /**
     * 注解方式测试分布式锁
     */
    //@Scheduled(cron = "0/5 * * * * ?")
    @DistributedLock(lockKey = "redis-lock", expireSeconds = 11)
    public void execute() throws InterruptedException {
        log.info("执行execute任务开始，休眠三秒");
        Thread.sleep(3000);
        System.out.println("=======================业务逻辑1=============================");
        Map map = new HashMap();
        map.put("orderId", "12345");
        map.put("orderId", "12345");
        rabbitMqClient.sendMessage("test", map);
        //延迟10秒发送
        map.put("orderId", "555555");
        rabbitMqClient.sendMessage("test", map, 10000);
        log.info("execute任务结束，休眠三秒");
    }

    /**
     * 编码方式测试分布式锁
     */
    //@Scheduled(cron = "0/3 * * * * ?")
    public void execute2() throws InterruptedException {
        if (redissonLock.tryLock("redisson", -1, 10)) {
            log.info("执行任务execute2开始，休眠三秒");
            Thread.sleep(3000);
            System.out.println("=======================业务逻辑2=============================");
            log.info("定时execute2结束，休眠三秒");
            redissonLock.unlock("redisson");
        } else {
            log.info("execute2获取锁失败");
        }
    }


}
