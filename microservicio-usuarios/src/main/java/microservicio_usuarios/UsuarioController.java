package microservicio_usuarios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping("/estado")
    public ResponseEntity<String> estado() {
        return ResponseEntity.ok("Microservicio de Usuarios funcionando correctamente.");
    }
}