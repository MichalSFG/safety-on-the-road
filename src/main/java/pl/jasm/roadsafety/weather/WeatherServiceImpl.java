package pl.jasm.roadsafety.weather;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Weather add(WeatherDto dto) {
        Weather weather = new Weather();
        weather.setCity(dto.getCityName());
        weather.setWeatherDescription(dto.getGeneralDescription());
        weather.setCountryCode(dto.getCountry());
        weather.setTemperature(dto.getTemp());
        weather.setFeels_like(dto.getFeelsLike());
        weather.setTemp_min(dto.getTempMin());
        weather.setTemp_max(dto.getTempMax());
        weather.setPressure(dto.getAirPressure());
        weather.setHumidity(dto.getAirHumidity());
        weather.setWindSpeed(dto.getWind());
        weather.setCloudsAltitude(dto.getClouds());
        weather.prePersist();
        weatherRepository.save(weather);
        return weather;
    }
}
