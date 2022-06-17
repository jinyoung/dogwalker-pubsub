package dog.walker.infra;

import dog.walker.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/walks")
@Transactional
public class WalkController {

    @Autowired
    WalkRepository walkRepository;

    @RequestMapping(
        value = "/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Walk start(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /walk/start  called #####");
        Optional<Walk> optionalWalk = walkRepository.findById(id);

        optionalWalk.orElseThrow(() -> new Exception("No Entity Found"));
        Walk walk = optionalWalk.get();
        walk.start();

        walkRepository.save(walk);
        return walk;
    }

    @RequestMapping(
        value = "/{id}/end",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Walk end(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /walk/end  called #####");
        Optional<Walk> optionalWalk = walkRepository.findById(id);

        optionalWalk.orElseThrow(() -> new Exception("No Entity Found"));
        Walk walk = optionalWalk.get();
        walk.end();

        walkRepository.save(walk);
        return walk;
    }
    // keep
}
