package pl.jasm.roadsafety.weather;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "weatherDetails")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryCode;
    private String city;
    private String weatherDescription;
    private String temperature;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String humidity;
    private String windSpeed;
    private String cloudsAltitude;
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }
}
