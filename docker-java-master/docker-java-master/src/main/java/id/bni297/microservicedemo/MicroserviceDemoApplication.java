package id.bni297.microservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "id.bni297.microservicedemo.repository")
public class MicroserviceDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemoApplication.class, args);
	}
}
