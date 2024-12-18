package model

import java.sql.Timestamp

data class Category(
    val idCategory: Long?,
    val nameCategory: String?,
    val description: String?,
    val creationDate: Timestamp?,
    val updateDate: Timestamp?
) {
    fun validNameCategory(valueDefault: String): String {
        return nameCategory?.let { name -> name } ?: valueDefault
    }

    fun validDescription(valueDefault: String): String {
        return description?.let { name -> name } ?: valueDefault
    }
}
