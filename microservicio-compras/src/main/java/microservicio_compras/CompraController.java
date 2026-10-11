package microservicio_compras;

import microservicio_compras.clients.JuegoClient;
import microservicio_compras.clients.UsuarioClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraService service;
    private final UsuarioClient usuarioClient;
    private final JuegoClient juegoClient;

    // Inyectamos los clientes en el constructor
    public CompraController(CompraService service, UsuarioClient usuarioClient, JuegoClient juegoClient) {
        this.service = service;
        this.usuarioClient = usuarioClient;
        this.juegoClient = juegoClient;
    }

    @GetMapping("/test-comunicacion")
    public ResponseEntity<String> testComunicacion() {
        // Hacemos llamadas reales a los otros microservicios
        String resUsuario = usuarioClient.verificarEstadoUsuario();
        String resJuego = juegoClient.verificarEstadoJuego();

        return ResponseEntity.ok("Respuesta de Usuarios: " + resUsuario + " | Respuesta de Juegos: " + resJuego);
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
