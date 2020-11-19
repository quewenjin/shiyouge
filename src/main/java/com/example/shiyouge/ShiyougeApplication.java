package com.example.shiyouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ShiyougeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyougeApplication.class, args);
    }

}
