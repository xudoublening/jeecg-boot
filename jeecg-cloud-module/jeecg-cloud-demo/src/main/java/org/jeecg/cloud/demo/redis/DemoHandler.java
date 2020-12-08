package org.jeecg.cloud.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.redis.listener.JeecgRedisListerer;
import org.jeecg.common.base.BaseMap;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhangjingbiao
 * @Date: 2020/12/7 11:24
 *  redis  发布订阅监听
 */
@Slf4j
@Component
public class DemoHandler implements JeecgRedisListerer {
    @Override
    public void onMessage(BaseMap message) {
        String orderId=message.get("orderId").toString();
        log.info("执行业务逻辑..............");
    }
}
