package pl.jasm.roadsafety.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherDto {

    @JsonProperty("name")
    private String cityName;
    private String generalDescription;
    private String country;
    private String temp;
    private String feelsLike;
    private String tempMin;
    private String tempMax;
    private String airPressure;
    private String airHumidity;
    private String wind;
    private String clouds;

    @JsonProperty("clouds")
    private void getCloudsAlt(Map<String, String> map) {
        this.clouds = map.get("all");
    }

    @JsonProperty("wind")
    private void getWindSpeed(Map<String, String> map) {
        this.wind = map.get("speed");
    }

    @JsonProperty("main")
    private void getTempDetails(Map<String, String> map) {
        this.temp = map.get("temp");
        this.feelsLike = map.get("feels_like");
        this.tempMin = map.get("temp_min");
        this.tempMax = map.get("temp_max");
        this.airPressure = map.get("pressure");
        this.airHumidity = map.get("humidity");
    }

    @JsonProperty("sys")
    private void getCountryCode(Map<String, String> map) {
        this.country = map.get("country");
    }

    @JsonProperty("weather")
    private void getGeneralWeatherDescription(Object[] array) {
        Map<String, String> map = (Map<String, String>) array[0];
        this.generalDescription = map.get("description");
    }
}
