package model

import java.sql.Timestamp

data class Category(
    val idCategory: Long?,
    val nameCategory: String,
    val description: String,
    val creationDate: Timestamp,
    val updateDate: Timestamp?
)
