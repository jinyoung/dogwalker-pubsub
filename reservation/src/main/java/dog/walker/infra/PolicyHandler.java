package dog.walker.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dog.walker.config.kafka.KafkaProcessor;
import dog.walker.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReservationRepository reservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverWalkStarted_UpdateStatus(
        @Payload WalkStarted walkStarted
    ) {
        if (!walkStarted.validate()) return;
        WalkStarted event = walkStarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + walkStarted.toJson() + "\n\n"
        );

        // Sample Logic //
        Reservation.updateStatus(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverWalkEnded_UpdateStatus(@Payload WalkEnded walkEnded) {
        if (!walkEnded.validate()) return;
        WalkEnded event = walkEnded;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + walkEnded.toJson() + "\n\n"
        );

        // Sample Logic //
        Reservation.updateStatus(event);
    }
    // keep

}
