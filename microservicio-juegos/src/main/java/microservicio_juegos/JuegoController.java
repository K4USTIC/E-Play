package microservicio_juegos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoRepository repository;

    public JuegoController(JuegoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Juego> crearJuego(@RequestBody Juego juego) {
        return ResponseEntity.ok(repository.save(juego));
    }

    @GetMapping
    public ResponseEntity<List<Juego>> obtenerJuegos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> obtenerJuegoPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint original para que Feign siga funcionando
    @GetMapping("/test-comunicacion")
    public String verificarEstadoJuego() {
        return "Microservicio de Juegos funcionando correctamente.";
    }
}