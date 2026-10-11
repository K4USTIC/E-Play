package microservicio_compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroservicioComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioComprasApplication.class, args);
	}

}
