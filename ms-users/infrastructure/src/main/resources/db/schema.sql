CREATE TABLE IF NOT EXISTS users (
    id_user SERIAL PRIMARY KEY,              -- Identificador único para cada usuario (autoincremental)
    name VARCHAR(100) NOT NULL,        -- Nombre del usuario
    email VARCHAR(150) UNIQUE NOT NULL,  -- Correo electrónico único
    password VARCHAR(255) NOT NULL,    -- Contraseña del usuario (encriptada)
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Fecha de creación del usuario
    update_date TIMESTAMP,  -- Fecha de creación del usuario
    es_active BOOLEAN DEFAULT TRUE       -- Estado del usuario (activo/inactivo)
);

INSERT INTO users (name, email, password) VALUES
('Juan Pérez', 'juan.perez@example.com', 'contraseña_encriptada'),
('Pepe Mojica', 'pepe.mojica@example.com', 'contraseña_encriptada'),
('Roman Solo', 'roman.solo@example.com', 'contraseña_encriptada');