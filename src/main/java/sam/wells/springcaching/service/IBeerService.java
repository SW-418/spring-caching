package sam.wells.springcaching.service;

import sam.wells.springcaching.model.Beer;

import java.util.List;
import java.util.UUID;

public interface IBeerService {
    Beer getBeer(UUID id);
    List<Beer> getBeers();
    Beer addBeer(Beer beer);
}
