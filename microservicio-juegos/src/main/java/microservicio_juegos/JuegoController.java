package microservicio_juegos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    @GetMapping("/estado")
    public ResponseEntity<String> estado() {
        return ResponseEntity.ok("Microservicio de Juegos funcionando correctamente.");
    }
}
