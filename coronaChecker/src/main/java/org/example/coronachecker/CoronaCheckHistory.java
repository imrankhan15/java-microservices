package org.example.coronachecker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CoronaCheckHistory {
    @Id
    @SequenceGenerator(
            name = "checker_id_sequence",
            sequenceName = "checker_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "checker_id_sequence"
    )
    private Integer id;
    private Integer passengerId;
    private Boolean isCoronaPositive;
    private LocalDateTime createdAt;

}
