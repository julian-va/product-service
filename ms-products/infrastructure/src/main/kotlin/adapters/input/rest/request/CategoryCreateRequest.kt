package jva.cloud.adapters.input.rest.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import java.sql.Timestamp

data class CategoryCreateRequest(
    @JsonProperty(value = "name_category")

    @field:NotBlank
    val nameCategory: String,
    @field:NotBlank
    val description: String,
    val creationDate: Timestamp = Timestamp(System.currentTimeMillis()),
)
