package pl.jasm.roadsafety;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jasm.roadsafety.hero.Hero;
import pl.jasm.roadsafety.hero.HeroRepository;

import java.util.stream.IntStream;

@SpringBootApplication
public class RoadSafetyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoadSafetyApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(HeroRepository heroRepository) {
//        Faker faker = new Faker();
//        return args -> IntStream.range(0, 10)
//                .forEach(i -> heroRepository.save(new Hero(faker.superhero().name())));
//    }

}
