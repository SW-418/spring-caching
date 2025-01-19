package sam.wells.springcaching.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sam.wells.springcaching.model.BeerDto;
import sam.wells.springcaching.model.CreateBeerRequestDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping
    public List<BeerDto> getBeers() {
        return List.of();
    }

    @GetMapping("{id}")
    public BeerDto getBeer(@PathVariable UUID id) {
        return new BeerDto(id, "Fat Tug", 5.0);
    }

    @PostMapping
    public BeerDto createBeer(@Valid @RequestBody CreateBeerRequestDto beerRequestDto) {
        return new BeerDto(UUID.randomUUID(), beerRequestDto.name(), beerRequestDto.percentage());
    }
}
