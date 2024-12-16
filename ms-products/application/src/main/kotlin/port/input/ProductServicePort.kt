package port.input

import model.Product

interface ProductServicePort : GenericServicePort<Long, Product> {
}