package dog.walker.domain;

import dog.walker.ReservationApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date start;

    private Date end;

    private String walkerId;

    private String ownerId;

    private String status;

    @PostPersist
    public void onPostPersist() {}

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    public static void updateStatus(WalkStarted walkStarted) {
        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

        /** Example 2:  finding and process
        */
        
        repository().findById(walkStarted.getReservationId()).ifPresent(reservation->{
            
            reservation.setStatus("STARTED");
            repository().save(reservation);


         });
        


    }

    public static void updateStatus(WalkEnded walkEnded) {
        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

        /** Example 2:  finding and process*/
        
        repository().findById(walkEnded.getReservationId()).ifPresent(reservation->{
            
            reservation.setStatus("FINISHED"); // do something
            repository().save(reservation);


         });
        

    }
}
