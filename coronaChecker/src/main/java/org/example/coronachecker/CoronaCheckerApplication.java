package org.example.coronachecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoronaCheckerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoronaCheckerApplication.class, args);
    }
}
