CREATE TABLE transaccion (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             usuario_id BIGINT NOT NULL,
                             juego_id BIGINT NOT NULL,
                             tipo_transaccion VARCHAR(50),
                             monto DECIMAL(10, 2),
                             fecha_transaccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);