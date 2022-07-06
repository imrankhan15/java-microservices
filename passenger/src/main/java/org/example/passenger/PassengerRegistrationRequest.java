package org.example.passenger;

public record PassengerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
