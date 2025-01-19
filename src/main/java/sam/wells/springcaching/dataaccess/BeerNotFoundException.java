package sam.wells.springcaching.dataaccess;

import java.util.UUID;

public class BeerNotFoundException extends RuntimeException {
    public BeerNotFoundException(final UUID id) {
        super(String.format("Beer %s not found\n", id));
    }
}
