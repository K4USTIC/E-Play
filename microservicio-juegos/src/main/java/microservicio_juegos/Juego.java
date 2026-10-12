package microservicio_juegos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "juego")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Double precio;
    private Boolean esLanzado;
}