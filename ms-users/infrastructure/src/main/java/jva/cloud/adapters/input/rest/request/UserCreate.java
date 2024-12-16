package jva.cloud.adapters.input.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UserCreate(
    @NotBlank() String name,
    @NotBlank() String email,
    @JsonProperty(value = "is_active") Boolean isActive) {}
