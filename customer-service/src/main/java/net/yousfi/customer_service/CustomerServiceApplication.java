package net.yousfi.customer_service;

import net.yousfi.customer_service.config.CustomerConfigParams;
import net.yousfi.customer_service.entities.Customer;
import net.yousfi.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder().name("Mohamed").email("med@gmail.com").build());
			customerRepository.save(Customer.builder().name("Imane").email("imane@gmail.com").build());
			customerRepository.save(Customer.builder().name("Yassine").email("yassine@gmail.com").build());

			customerRepository.findAll().forEach(
					customer -> {
						System.out.println("===========================");
						System.out.println(customer.getId());
						System.out.println( customer.getName());
						System.out.println(customer.getEmail());
						System.out.println("===========================");
					}
			);
		};
	}
}
