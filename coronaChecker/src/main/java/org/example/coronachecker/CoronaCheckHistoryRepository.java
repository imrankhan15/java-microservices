package org.example.coronachecker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoronaCheckHistoryRepository
        extends JpaRepository<CoronaCheckHistory, Integer> {
}
