package microservicio_usuarios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // 1. Endpoint para crear un usuario nuevo (POST)
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = repository.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // 2. Endpoint para obtener TODOS los usuarios (GET)
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(repository.findAll());
    }

    // 3. Endpoint para obtener un usuario por su ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Mantenemos el endpoint original para que Feign en Compras no falle
    @GetMapping("/test-comunicacion")
    public String verificarEstadoUsuario() {
        return "Microservicio de Usuarios funcionando correctamente.";
    }
}