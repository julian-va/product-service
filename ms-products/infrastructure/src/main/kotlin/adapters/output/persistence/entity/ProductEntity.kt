package jva.cloud.adapters.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp

@Table(name = "products")
data class ProductEntity(
    @Column(value = "id_product")
    @Id
    val idProduct: Long?,
    @Column(value = "name_product")
    val nameProduct: String,
    val description: String,
    val price: Double,
    val amount: Int,
    @Column(value = "id_category")
    val idCategory: Int,
    @Column(value = "creation_date")
    val creationDate: Timestamp,
    @Column(value = "update_date")
    val updateDate: Timestamp
)
