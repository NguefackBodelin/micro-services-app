package net.yousfi.billing_service.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.yousfi.billing_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCustomers")
    PagedModel<Customer> getAllCustomer();

    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder()
                .id(id)
                .name("default name")
                .email("defaultEmail")
                .build();
    }

    default PagedModel<Customer> getDefaultCustomers(Long id, Exception e){
        return PagedModel.empty();
    }
}
