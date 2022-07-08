package com.cyh.smarthome;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@MapperScan("com.cyh.smarthome.dal")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Environment env = SpringApplication.run(DemoApplication.class, args).getEnvironment();
        log.info("started: {},CPU core: {}", Arrays.toString(env.getActiveProfiles()), Runtime.getRuntime().availableProcessors());
    }

}
