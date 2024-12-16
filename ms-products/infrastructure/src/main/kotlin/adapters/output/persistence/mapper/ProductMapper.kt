package jva.cloud.adapters.output.persistence.mapper

import jva.cloud.adapters.output.persistence.entity.ProductEntity
import model.Product
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ProductMapper {
    fun toProductEntity(product: Product): ProductEntity
    fun toProduct(productEntity: ProductEntity): Product
    fun toListProduct(productEntities: List<ProductEntity>): List<Product>
}