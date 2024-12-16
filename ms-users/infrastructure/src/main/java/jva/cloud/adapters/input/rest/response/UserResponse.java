package jva.cloud.adapters.input.rest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

@JsonFormat()
public record UserResponse(
    Long id,
    String name,
    String email,
    @JsonProperty(value = "creation_date") Timestamp creationDate,
    @JsonProperty(value = "update_date") Timestamp updateDate,
    @JsonProperty(value = "is_active") Boolean isActive) {}
