package sam.wells.springcaching.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sam.wells.springcaching.model.Beer;
import sam.wells.springcaching.model.BeerDto;
import sam.wells.springcaching.model.CreateBeerRequestDto;
import sam.wells.springcaching.service.IBeerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final IBeerService beerService;

    public BeerController(final IBeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public List<BeerDto> getBeers() {
        return beerService.getBeers()
                .stream()
                .map(b -> new BeerDto(b.id(), b.name(), b.percentage()))
                .toList();
    }

    @GetMapping("{id}")
    public BeerDto getBeer(@PathVariable UUID id) {
        var beer = beerService.getBeer(id);
        return new BeerDto(beer.id(), beer.name(), beer.percentage());
    }

    @PostMapping
    public BeerDto createBeer(@Valid @RequestBody CreateBeerRequestDto beerRequestDto) {
        var beer = beerService.addBeer(new Beer(null, beerRequestDto.name(), beerRequestDto.percentage()));
        return new BeerDto(beer.id(), beer.name(), beer.percentage());
    }
}
