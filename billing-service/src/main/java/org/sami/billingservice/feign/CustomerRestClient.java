package org.sami.billingservice.feign;

import org.sami.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping(path = "/api/customers/{id}")
    Customer findCustomerById(@PathVariable long id);

    @GetMapping(path = "/api/customers")
    PagedModel<Customer> getAllCustomers();
}
