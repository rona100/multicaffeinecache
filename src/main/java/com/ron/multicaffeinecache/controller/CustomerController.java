package com.ron.multicaffeinecache.controller;

import com.ron.multicaffeinecache.model.Customer;
import com.ron.multicaffeinecache.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
//    @Cacheable(value = "cache-a", cacheManager = "myCacheManager")
    public Customer getCustomerName(@PathVariable @Valid @Min(1) int id) {
//        return new Customer(id, String.format("name:%d",id));
        return customerService.getCustomerName(id);

    }

}
