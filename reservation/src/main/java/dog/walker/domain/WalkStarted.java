package dog.walker.domain;

import dog.walker.domain.*;
import dog.walker.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class WalkStarted extends AbstractEvent {

    private Long id;
    private String dogWalkerId;
    private Date start;
    private Date end;
    private Long reservationId;
    // keep

}
