package org.example.passenger;

import lombok.AllArgsConstructor;
import org.example.amqp.RabbitMQMessageProducer;
import org.example.clients.checker.CoronaCheckResponse;
import org.example.clients.checker.CoronaCheckerClient;
import org.example.clients.notification.NotificationClient;
import org.example.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PassengerService{

    private final  PassengerRepository passengerRepository;
    private final RestTemplate restTemplate;
    private final CoronaCheckerClient coronaCheckerClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    private final NotificationClient notificationClient;
    public void registerPassenger(PassengerRegistrationRequest request) {
        Passenger passenger = Passenger.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        passengerRepository.saveAndFlush(passenger);



        CoronaCheckResponse coronaCheckResponse =  coronaCheckerClient.isCoronaPositive(passenger.getId());
        if (coronaCheckResponse.isCoronaPositive()) {
            throw new IllegalStateException("coronapositive");
        }


        NotificationRequest notificationRequest =   new NotificationRequest(
                        passenger.getId(),
                        passenger.getEmail(),
                        String.format("Hi %s, welcome to  Bangladesh Biman...",
                                passenger.getFirstName())
                )
       ;


        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

    }
}
