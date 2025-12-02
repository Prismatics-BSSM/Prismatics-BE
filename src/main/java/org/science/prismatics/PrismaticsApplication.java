package org.science.prismatics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PrismaticsApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrismaticsApplication.class, args);
    }

}

@Component
class DebugDbUrl implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔍 [DEBUG] spring.datasource.url = " + datasourceUrl);
    }
}