package org.example.coronachecker;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CoronaCheckService {

    private final CoronaCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isCoronaAffectedPassenger(Integer passengerId) {
        fraudCheckHistoryRepository.save(
                CoronaCheckHistory.builder()
                        .passengerId(passengerId)
                        .isCoronaPositive(Boolean.FALSE)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
