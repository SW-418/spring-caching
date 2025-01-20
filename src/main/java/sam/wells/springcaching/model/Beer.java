package sam.wells.springcaching.model;

import java.io.Serializable;
import java.util.UUID;

public record Beer(UUID id, String name, Double percentage) implements Serializable { }
