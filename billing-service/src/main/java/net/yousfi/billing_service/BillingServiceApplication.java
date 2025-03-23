package net.yousfi.billing_service;

import net.yousfi.billing_service.entities.Bill;
import net.yousfi.billing_service.entities.ProductItem;
import net.yousfi.billing_service.feign.CustomerRestClient;
import net.yousfi.billing_service.feign.ProductRestClient;
import net.yousfi.billing_service.model.Customer;
import net.yousfi.billing_service.model.Product;
import net.yousfi.billing_service.repository.BillRepository;
import net.yousfi.billing_service.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient,
							  ProductRestClient productRestClient){
		Collection<Customer> customers = customerRestClient.getAllCustomer().getContent();
		Collection<Product> products = productRestClient.getAllProduct().getContent();

		return args ->  customers.forEach(customer -> {
					Bill bill = Bill.builder()
							.billingDate(new Date())
							.customerId(customer.getId())
							.build();
					billRepository.save(bill);

			products.forEach(product -> {
				ProductItem productItem = ProductItem.builder()
						.bill(bill)
						.ProductId(product.getId())
						.quantity(1+new Random().nextInt(10))
						.unitPrice(product.getPrice())
						.build();
				productItemRepository.save(productItem);
			});
				}

		);
	}
}
