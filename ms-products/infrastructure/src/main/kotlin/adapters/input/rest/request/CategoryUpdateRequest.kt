package jva.cloud.adapters.input.rest.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class CategoryUpdateRequest(
    @JsonProperty(value = "name_category")
    val nameCategory: String?,
    val description: String?,
    val updateDate: Timestamp = Timestamp(System.currentTimeMillis()),
)
