package org.example.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "org.example.passenger",
                "org.example.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.example.clients"
)
public class PassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassengerApplication.class, args);
    }
}
