package org.science.prismatics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PrismaticsApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrismaticsApplication.class, args);
    }

}