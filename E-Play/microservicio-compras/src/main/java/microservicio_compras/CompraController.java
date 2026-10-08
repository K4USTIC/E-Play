package microservicio_compras;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ventas")
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping("/procesar")
    public ResponseEntity<?> procesar(@RequestBody TransaccionDTO dto) {
        try {
            Transaccion res = service.procesar(dto.usuarioId(), dto.juegoId(), dto.esLanzado(), dto.pagoExitoso());
            if ("RESERVA".equals(res.getTipoTransaccion())) {
                return ResponseEntity.ok("Reserva Confirmada. Quedan días para el lanzamiento.");
            }
            return ResponseEntity.ok("Compra exitosa. Código digital generado.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
