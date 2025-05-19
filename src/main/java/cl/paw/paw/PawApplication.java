package cl.paw.paw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "cl.paw.paw.model")
public class PawApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawApplication.class, args);
	}

}
