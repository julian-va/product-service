package jva.cloud.adapters.input.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserUpdate(String name, String email,
                         @JsonProperty(value = "is_active") Boolean isActive) {
}
