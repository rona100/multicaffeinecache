package com.ron.multicaffeinecache.service;

import com.ron.multicaffeinecache.model.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Slf4j
public class CustomerService {
    @Cacheable(value = "cache-c", cacheManager = "myCacheManager")
    public Customer getCustomerName(@PathVariable @Valid @Min(1) int id) {
        log.info("inside CustomerService::getCustomerName({})", id);
        return new Customer(id, String.format("name:%d",id));
    }
}
