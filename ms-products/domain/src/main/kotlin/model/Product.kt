package model

import java.sql.Timestamp

data class Product(
    val idProduct: Long?,
    val nameProduct: String,
    val description: String,
    val price: Double,
    val amount: Int,
    val idCategory: Int,
    val creationDate: Timestamp,
    val updateDate: Timestamp?
)
