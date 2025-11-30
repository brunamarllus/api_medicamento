package main.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Escaneia os pacotes de controller e model porque esta classe Application está no pacote `main.java.service`
@SpringBootApplication(scanBasePackages = {"main.java.service", "main.java.controller", "main.java.model"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
