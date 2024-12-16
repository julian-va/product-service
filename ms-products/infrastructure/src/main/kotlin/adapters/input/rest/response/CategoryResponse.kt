package jva.cloud.adapters.input.rest.response

import java.sql.Timestamp

data class CategoryResponse(
    val idCategory: Long?,
    val nameCategory: String,
    val description: String,
    val creationDate: Timestamp,
    val updateDate: Timestamp?
)
