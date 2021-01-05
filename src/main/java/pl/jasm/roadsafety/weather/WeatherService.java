package pl.jasm.roadsafety.weather;

import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    Weather add(WeatherDto dto);
}
