package org.jeecg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: jeecg-boot-parent
 * @description: 风控服务启动类
 * @author: XNN
 * @create: 2020-12-08 17:01
 **/
@EnableScheduling
@EnableFeignClients(basePackages = {"org.jeecg"})
@SpringBootApplication(scanBasePackages = "org.jeecg")
public class RiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiskApplication.class,args);
    }
    
}
