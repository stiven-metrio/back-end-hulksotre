package com.jssm.kardex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sealor.kardex.controller", "com.sealor.kardex.service", "com.sealor.kardex.repository"})
public class KardexApplication {

    public static void main(String[] args) {
        SpringApplication.run(KardexApplication.class, args);
    }

}
