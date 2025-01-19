package sam.wells.springcaching.dataaccess;

import sam.wells.springcaching.model.Beer;

import java.util.List;
import java.util.UUID;

public interface IBeerDataAccessor {
    Beer getBeer(UUID id);
    List<Beer> getBeers();
    Beer addBeer(Beer beer);
}
