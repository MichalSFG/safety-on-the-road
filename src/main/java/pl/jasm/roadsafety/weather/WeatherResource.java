package pl.jasm.roadsafety.weather;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.jasm.roadsafety.exception.ResourceNotFoundException;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/weather")
@Slf4j
public class WeatherResource {

    private final WeatherService weatherService;

    public WeatherResource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/details/{city}/{country}")
    public ResponseEntity<Weather> getWeatherDetails(@PathVariable String city, @PathVariable(value = "country") String countryCode) throws ResourceNotFoundException {
        String api = "https://community-open-weather-map.p.rapidapi.com/weather?rapidapi-key=e074a51343msh7118a0a29cea5dcp1906bdjsnd2a1bd495bab&q="
                + city + "%2C" + countryCode + "&units=metric";
        String decodedUrl = URLDecoder.decode(api, StandardCharsets.UTF_8);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<WeatherDto> responseEntity = restTemplate.getForEntity(decodedUrl, WeatherDto.class);
            WeatherDto weatherDto = responseEntity.getBody();
            Weather weather = weatherService.add(weatherDto);
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } catch (RestClientException e) {
            throw new ResourceNotFoundException("no data available");
        }
    }
}
