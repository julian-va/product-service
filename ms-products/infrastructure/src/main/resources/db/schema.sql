-- Eliminar las tablas si ya existen
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS orders CASCADE;

-- Creación de la tabla 'categoria'
CREATE TABLE categories (
    id_category SERIAL PRIMARY KEY,  -- ID único y autoincrementable para la categoría
    name_category VARCHAR(100) NOT NULL,     -- Nombre de la categoría
    description TEXT,                 -- Descripción opcional de la categoría
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Fecha de creación del usuario
    update_date TIMESTAMP  -- Fecha de creación del usuario
);

-- Creación de la tabla 'producto'
CREATE TABLE products (
    id_product SERIAL PRIMARY KEY,      -- ID único y autoincrementable para el producto
    name_product VARCHAR(100) NOT NULL,        -- Nombre del producto
    description TEXT,                    -- Descripción del producto
    price DECIMAL(10, 2) NOT NULL,      -- Precio del producto (con 2 decimales)
    amount INT DEFAULT 0,              -- Cantidad en stock del producto
    id_category INT,                    -- ID de la categoría a la que pertenece el producto
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Fecha de creación del usuario
    update_date TIMESTAMP,  -- Fecha de creación del usuario
    CONSTRAINT fk_categories
        FOREIGN KEY (id_category)      -- Relación con la tabla 'categoria'
        REFERENCES categories(id_category)
        ON DELETE SET NULL              -- Si se elimina una categoría, se pone a NULL el id_categoria de los productos relacionados
);

-- Creación de la tabla 'orders'
CREATE TABLE orders (
    id_order SERIAL PRIMARY KEY,
    id_user INT NOT NULL,
    id_product INT NOT NULL,                   -- ID de la categoría a la que pertenece el producto
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Fecha de creación del usuario
    update_date TIMESTAMP,  -- Fecha de creación del usuario
        CONSTRAINT fk_products
            FOREIGN KEY (id_product)      -- Relación con la tabla 'categoria'
            REFERENCES products(id_product)
            ON DELETE SET NULL
);

-- Agregar algunos datos de ejemplo en la tabla 'categoria'
INSERT INTO categories (name_category, description) VALUES
('Electrónica', 'Dispositivos y aparatos electrónicos'),
('Ropa', 'Prendas de vestir y accesorios'),
('Hogar', 'Productos para el hogar y decoración');

-- Agregar algunos datos de ejemplo en la tabla 'producto'
INSERT INTO products (name_product, description, price, amount, id_category) VALUES
('Smartphone', 'Teléfono móvil con pantalla de 6.5 pulgadas', 300.00, 10, 1),
('Camiseta', 'Camiseta de algodón tamaño M', 15.50, 25, 2),
('Sofá', 'Sofá de 3 plazas de tela', 500.00, 5, 3);

INSERT INTO orders (id_user, id_product) VALUES
(1, 1),
(2, 2),
(3, 3);