package dog.walker.domain;

import dog.walker.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "walks", path = "walks")
public interface WalkRepository
    extends PagingAndSortingRepository<Walk, Long> {}
