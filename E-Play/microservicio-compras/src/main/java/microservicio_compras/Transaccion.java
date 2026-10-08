package microservicio_compras;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACCIONES")
@Data
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;
    private Long juegoId;
    private String tipoTransaccion;
    private String estadoPago;
    private LocalDateTime fechaTransaccion;
}
