package jva.cloud.adapters.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp

@Table(name = "categories")
data class OrderEntity(
    @Column(value = "id_order")
    @Id
    val idOrder: Long?,
    @Column(value = "id_user")
    val idUser: Long,
    @Column(value = "id_product")
    val idProduct: Long,
    @Column(value = "creation_date")
    val creationDate: Timestamp,
    @Column(value = "update_date")
    val updateDate: Timestamp
)