CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);