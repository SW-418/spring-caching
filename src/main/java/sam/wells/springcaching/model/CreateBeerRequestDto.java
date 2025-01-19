package sam.wells.springcaching.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBeerRequestDto(
        @NotBlank(message = "Beer name must be provided") String name,
        @NotNull(message = "Beer percentage must be provided") Double percentage
) { }
