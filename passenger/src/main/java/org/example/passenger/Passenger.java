package org.example.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passenger {

    @Id
    @SequenceGenerator(
            name = "passenger_id_sequence",
            sequenceName = "passenger_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "passenger_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
