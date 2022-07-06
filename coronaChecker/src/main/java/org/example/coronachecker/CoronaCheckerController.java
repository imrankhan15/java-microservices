package org.example.coronachecker;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clients.checker.CoronaCheckResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/corona-check")
@AllArgsConstructor
@Slf4j
public class CoronaCheckerController {

    private final CoronaCheckService coronaCheckService;

    @GetMapping(path = "{passengerId}")
    public CoronaCheckResponse isCoronaAffected(
            @PathVariable("passengerId") Integer passengerID) {
        boolean isCoronaPassenger = coronaCheckService.
                isCoronaAffectedPassenger(passengerID);
        log.info("corona check request for customer {}", passengerID);

        return new CoronaCheckResponse(isCoronaPassenger);
    }
}
