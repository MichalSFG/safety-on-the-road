package pl.jasm.roadsafety.advice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RoadAdviceDto {

    @JsonProperty("title")
    private String adviceName;

    @JsonProperty("uploader")
    private String adviceUploader;

    @JsonProperty("url")
    private String adviceUrl;

    @JsonProperty("description")
    private String adviceDesc;

    @JsonProperty("upload_date")
    private String adviceUploadDate;
}
