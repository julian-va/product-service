package jva.cloud.adapters.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp

@Table(name = "categories")
data class CategoryEntity(
    @Column(value = "id_category")
    @Id val idCategory: Long?,
    val nameCategory: String,
    val description: String,
    @Column(value = "creation_date")
    val creationDate: Timestamp,
    @Column(value = "update_date")
    val updateDate: Timestamp?
)
