package org.example.clients.checker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("coronaChecker")
public interface CoronaCheckerClient {

    @GetMapping(path = "api/v1/corona-check/{passengerId}")
    CoronaCheckResponse isCoronaPositive(
            @PathVariable("passengerId") Integer passengerId);

}
