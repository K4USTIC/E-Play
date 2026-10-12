package microservicio_compras.clients;

import microservicio_compras.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-usuarios", url = "http://localhost:8082")
public interface UsuarioClient {
    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable("id") Long id);
}