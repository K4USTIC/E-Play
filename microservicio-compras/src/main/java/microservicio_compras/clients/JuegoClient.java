package microservicio_compras.clients;

import microservicio_compras.JuegoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-juegos", url = "http://localhost:8083")
public interface JuegoClient {
    @GetMapping("/api/juegos/{id}")
    JuegoDTO obtenerJuego(@PathVariable("id") Long id);
}