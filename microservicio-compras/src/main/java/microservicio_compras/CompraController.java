package microservicio_compras;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping("/procesar")
    public ResponseEntity<?> procesar(@RequestBody TransaccionDTO dto) {
        Transaccion res = service.procesar(dto.usuarioId(), dto.juegoId(), dto.pagoExitoso());

        if ("RESERVA".equals(res.getTipoTransaccion())) {
            return ResponseEntity.ok(Map.of("mensaje", "Reserva Confirmada. Quedan días para el lanzamiento."));
        }
        return ResponseEntity.ok(Map.of("mensaje", "Compra exitosa. Código digital generado."));
    }
}