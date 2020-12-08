package org.jeecg.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控服务
 * 2020/12/04 14:34:49
 */
@SpringBootApplication
@EnableAdminServer
public class JeecgMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeecgMonitorApplication.class);
    }
}