package ru.kondrashkov.webspring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSpringApplication.class, args);
    }
}
