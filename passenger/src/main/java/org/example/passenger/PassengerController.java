package org.example.passenger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/passengers")
public record PassengerController(PassengerService passengerService) {

    @PostMapping
    public void registerCustomer(@RequestBody PassengerRegistrationRequest passengerRegistrationRequest) {
        log.info("new customer registration {}", passengerRegistrationRequest);
        passengerService.registerPassenger(passengerRegistrationRequest);
    }
}
