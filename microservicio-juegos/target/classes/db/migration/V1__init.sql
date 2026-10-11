CREATE TABLE juego (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       titulo VARCHAR(150) NOT NULL,
                       precio DECIMAL(10, 2) NOT NULL,
                       es_lanzado BOOLEAN DEFAULT TRUE
);