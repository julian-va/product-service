package port.oatput

import model.Category

interface CategoryPersistencePort : GenericPersistencePort<Long, Category> {
}