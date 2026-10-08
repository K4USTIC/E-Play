package microservicio_compras;

public record TransaccionDTO(Long usuarioId, Long juegoId, boolean esLanzado, boolean pagoExitoso) {}