package com.ludo.msui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsuiApplication.class, args);
    }

}
