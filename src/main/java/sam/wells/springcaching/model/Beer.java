package sam.wells.springcaching.model;

import java.util.UUID;

public record Beer(UUID id, String name, Double percentage) { }
