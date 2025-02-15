package org.sami.billingservice.web;

import org.sami.billingservice.entities.Bill;
import org.sami.billingservice.feign.CustomerRestClient;
import org.sami.billingservice.feign.ProductRestClient;
import org.sami.billingservice.repository.BillRepository;
import org.sami.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private CustomerRestClient customerRestClient;

    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bills/{id}")
    Bill getBill(@PathVariable Long id){

    Bill bill = billRepository.findById(id).get();
    return bill;
    }
}
