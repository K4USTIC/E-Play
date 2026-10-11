package microservicio_compras.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservicio-usuarios", url = "http://localhost:8082/api/usuarios")
public interface UsuarioClient {

    @GetMapping("/estado")
    String verificarEstadoUsuario();
}