package pl.jasm.roadsafety;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jasm.roadsafety.exception.ResourceNotFoundException;
import pl.jasm.roadsafety.hero.Hero;
import pl.jasm.roadsafety.hero.HeroRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class HeroResource {

    private final HeroRepository heroRepository;

    public HeroResource(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping("/chuck-fact")
    public String chuckFact() {
        return new Faker().chuckNorris().fact();
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Long id) {
        Optional<Hero> hero = heroRepository.findById(id);
        return hero.map(h -> new ResponseEntity<>(h, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getAllHeroes(Pageable pageable) {
        Page<Hero> heroes = heroRepository.findAll(pageable);
        return new ResponseEntity<>(heroes.getContent(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addHero(@RequestBody Hero hero) {
        log.info("added hero {}", hero.getName());
        heroRepository.save(hero);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable Long id, @RequestBody Hero hero) throws ResourceNotFoundException {
        Hero updatedHero = heroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("hero not found for id " + id));

        updatedHero.setName(hero.getName());
        return ResponseEntity.ok(heroRepository.save(updatedHero));
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteHero(@PathVariable Long id) throws ResourceNotFoundException {
        Hero hero = heroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("hero not found for id " + id));

        heroRepository.delete(hero);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
