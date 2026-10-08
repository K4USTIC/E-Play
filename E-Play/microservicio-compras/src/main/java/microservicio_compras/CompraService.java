package microservicio_compras;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CompraService {

    private final TransaccionRepository repository;

    public CompraService(TransaccionRepository repository) {
        this.repository = repository;
    }

    public Transaccion procesar(Long usuarioId, Long juegoId, boolean esLanzado, boolean pagoValido) {
        Transaccion t = new Transaccion();
        t.setUsuarioId(usuarioId);
        t.setJuegoId(juegoId);
        t.setFechaTransaccion(LocalDateTime.now());

        if (!pagoValido) {
            t.setEstadoPago("RECHAZADO");
            repository.save(t);
            throw new RuntimeException("Pago Fallido. Excepción capturada.");
        }

        t.setEstadoPago("APROBADO");
        t.setTipoTransaccion(esLanzado ? "COMPRA" : "RESERVA");
        return repository.save(t);
    }
}
