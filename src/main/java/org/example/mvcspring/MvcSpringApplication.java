package org.example.mvcspring;

import org.example.mvcspring.entities.Product;
import org.example.mvcspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product product1 = Product.builder()
                    .name("computer")
                    .price(5400)
                    .quantity(1) // Ajout de quantité si requis dans le builder
                    .build();
            Product product2 = Product.builder()
                    .name("laptop")
                    .price(7800)
                    .quantity(3)
                    .build();
            Product product3 = Product.builder()
                    .name("play")
                    .price(4500)
                    .quantity(2)
                    .build();

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);

            productRepository.findAll().forEach(p -> System.out.println(p));
        };
    }
}
