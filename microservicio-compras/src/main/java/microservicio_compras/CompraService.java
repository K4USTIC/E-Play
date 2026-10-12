package microservicio_compras;

import microservicio_compras.clients.JuegoClient;
import microservicio_compras.clients.UsuarioClient;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private final TransaccionRepository repository;
    private final UsuarioClient usuarioClient;
    private final JuegoClient juegoClient;

    public CompraService(TransaccionRepository repository, UsuarioClient usuarioClient, JuegoClient juegoClient) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
        this.juegoClient = juegoClient;
    }

    public Transaccion procesar(Long usuarioId, Long juegoId, boolean pagoExitoso) {

        System.out.println("--- VALIDANDO COMPRA CON MICROSERVICIOS ---");

        // 1. Validar que el usuario exista
        UsuarioDTO usuario;
        try {
            usuario = usuarioClient.obtenerUsuario(usuarioId);
            System.out.println("Usuario validado: " + usuario.nombre());
        } catch (Exception e) {
            throw new RuntimeException("Error: El usuario no existe.");
        }

        // 2. Validar que el juego exista
        JuegoDTO juego;
        try {
            juego = juegoClient.obtenerJuego(juegoId);
            System.out.println("Juego validado: " + juego.titulo() + " | Precio: $" + juego.precio());
        } catch (Exception e) {
            throw new RuntimeException("Error: El juego no existe.");
        }

        // 3. Validar pago
        if (!pagoExitoso) {
            throw new RuntimeException("Error: Pago rechazado.");
        }

        // 4. Guardar Transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setUsuarioId(usuario.id());
        transaccion.setJuegoId(juego.id());
        transaccion.setTipoTransaccion(juego.esLanzado() ? "COMPRA" : "RESERVA");

        return repository.save(transaccion);
    }
}