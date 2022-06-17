package dog.walker.infra;

import dog.walker.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class WalkHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Walk>> {

    @Override
    public EntityModel<Walk> process(EntityModel<Walk> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/start")
                .withRel("start")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/end")
                .withRel("end")
        );

        return model;
    }
}
