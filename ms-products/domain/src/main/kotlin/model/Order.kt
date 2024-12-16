package model

import java.sql.Timestamp

data class Order(
    val idOrder: Long?,
    val idUser: Long,
    val idProduct: Long,
    val creationDate: Timestamp,
    val updateDate: Timestamp?
)
