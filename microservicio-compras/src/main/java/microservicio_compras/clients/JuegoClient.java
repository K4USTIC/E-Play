package microservicio_compras.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservicio-juegos", url = "http://localhost:8083/api/juegos")
public interface JuegoClient {

    @GetMapping("/estado")
    String verificarEstadoJuego();
}