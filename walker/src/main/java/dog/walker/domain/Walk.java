package dog.walker.domain;

import dog.walker.WalkerApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Walk_table")
@Data
public class Walk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dogWalkerId;

    private Date start;

    private Date end;

    private Long reservationId;

    @PostPersist
    public void onPostPersist() {}

    public static WalkRepository repository() {
        WalkRepository walkRepository = WalkerApplication.applicationContext.getBean(
            WalkRepository.class
        );
        return walkRepository;
    }

    public void start() {
        setStart(new Date());  // set current date for starting

        WalkStarted walkStarted = new WalkStarted(this);
        walkStarted.publishAfterCommit();
    }

    public void end() {
        setEnd(new Date()); // set current date for ending

        WalkEnded walkEnded = new WalkEnded(this);
        walkEnded.publishAfterCommit();
    }
}
