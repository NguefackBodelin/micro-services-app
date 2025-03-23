package net.yousfi.inventory_service;

import net.yousfi.inventory_service.entities.Product;
import net.yousfi.inventory_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
					.Id(UUID.randomUUID().toString())
							.name("computer")
							.price(3200)
							.quantity(11)
					.build());
			productRepository.save(Product.builder()
					.Id(UUID.randomUUID().toString())
							.name("printer")
							.price(1299)
							.quantity(10)
					.build());
			productRepository.save(Product.builder()
					.Id(UUID.randomUUID().toString())
							.name("smart phone")
							.price(5400)
							.quantity(8)
					.build());


			productRepository.findAll().forEach( product -> product.toString());
		};
	}

}
