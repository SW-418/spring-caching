package sam.wells.springcaching.service;

import org.springframework.stereotype.Service;
import sam.wells.springcaching.dataaccess.IBeerDataAccessor;
import sam.wells.springcaching.model.Beer;

import java.util.List;
import java.util.UUID;

@Service
public class BeerService implements IBeerService {
    private final IBeerDataAccessor beerDataAccessor;

    public BeerService(final IBeerDataAccessor beerDataAccessor) {
        this.beerDataAccessor = beerDataAccessor;
    }

    @Override
    public Beer getBeer(final UUID id) {
        return beerDataAccessor.getBeer(id);
    }

    @Override
    public List<Beer> getBeers() {
        return beerDataAccessor.getBeers();
    }

    @Override
    public Beer addBeer(final Beer beer) {
        return beerDataAccessor.addBeer(beer);
    }
}

