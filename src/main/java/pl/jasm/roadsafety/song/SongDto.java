package pl.jasm.roadsafety.song;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SongDto {

    @JsonProperty("title")
    private String songTitle;

    @JsonProperty("url")
    private String urlAddress;

    @JsonProperty("uploader")
    private String songUploader;

    @JsonProperty("view_count")
    private String views;
}
