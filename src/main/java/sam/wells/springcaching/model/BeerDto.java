package sam.wells.springcaching.model;

import jakarta.annotation.Nonnull;

import java.util.UUID;

public record BeerDto(
        @Nonnull UUID id,
        @Nonnull String name,
        @Nonnull Double percentage) {
}
