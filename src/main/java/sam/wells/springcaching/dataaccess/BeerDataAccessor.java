package sam.wells.springcaching.dataaccess;

import org.springframework.stereotype.Component;
import sam.wells.springcaching.model.Beer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class BeerDataAccessor implements IBeerDataAccessor {
    private final Map<UUID, Beer> pretendExternalBeerService;

    public BeerDataAccessor() {
        this.pretendExternalBeerService = new HashMap<>();
        pretendExternalBeerService.put(UUID.fromString("2665a16c-387c-4cfc-9dc1-03c802cc71d2"), new Beer(UUID.fromString("2665a16c-387c-4cfc-9dc1-03c802cc71d2"), "Fat Tug", 5.0));
        pretendExternalBeerService.put(UUID.fromString("1ec5f69a-7dfd-4134-aa82-b27a386d4250"), new Beer(UUID.fromString("1ec5f69a-7dfd-4134-aa82-b27a386d4250"), "Stinky Skunk", 10.0));
        pretendExternalBeerService.put(UUID.fromString("f434e035-8c10-4086-ad25-526b2d1a485b"), new Beer(UUID.fromString("f434e035-8c10-4086-ad25-526b2d1a485b"), "Literal piss", 0.5));
        pretendExternalBeerService.put(UUID.fromString("438361cf-0620-403e-8cfa-a0522376478e"), new Beer(UUID.fromString("438361cf-0620-403e-8cfa-a0522376478e"), "Loafa Bread", 2.5));
        pretendExternalBeerService.put(UUID.fromString("b29a8169-07bd-41e1-9d94-2551ce6f5e22"), new Beer(UUID.fromString("b29a8169-07bd-41e1-9d94-2551ce6f5e22"), "Inversion Pilsner", 3.5));
    }

    @Override
    public Beer getBeer(final UUID id) {
        if (!pretendExternalBeerService.containsKey(id)) throw new BeerNotFoundException(id);

        return pretendExternalBeerService.get(id);
    }

    @Override
    public List<Beer> getBeers() {
        return pretendExternalBeerService.values().stream().toList();
    }

    @Override
    public Beer addBeer(Beer beer) {
        // TODO: Existence checks + handles
        var id = UUID.randomUUID();
        pretendExternalBeerService.put(id, new Beer(id, beer.name(), beer.percentage()));

        return pretendExternalBeerService.get(id);
    }
}
