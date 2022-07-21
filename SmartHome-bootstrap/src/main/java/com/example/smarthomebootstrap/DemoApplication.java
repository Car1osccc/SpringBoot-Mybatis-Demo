package com.example.smarthomebootstrap;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * @author Yihan Chen
 * @date 2022/7/27 13:59
 */
@Slf4j
@MapperScan("com.example.smarthomecommondal")
@SpringBootApplication(scanBasePackages = "com.example")
@EnableApolloConfig
@EnableFeignClients(basePackages = "com.example")
public class DemoApplication {

    public static void main(String[] args) {
        Environment env = SpringApplication.run(DemoApplication.class, args).getEnvironment();
        log.info("started: {},CPU core: {}", Arrays.toString(env.getActiveProfiles()), Runtime.getRuntime().availableProcessors());
    }

}
