package com.guo.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * 若pom.xml配置了 数据库连接, 但实际没有进行连接,须有如下配置
 * DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BootSsoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSsoTestApplication.class, args);
    }
}
