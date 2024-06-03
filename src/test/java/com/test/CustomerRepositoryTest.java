package com.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testOneColumn() {
        Iterable<Customer> customers = customerRepository.findAll(0, 10, Sort.by(Sort.Direction.ASC, "id"), Set.of("id"));

        assertThat(customers).hasSize(3);

        Customer customer = customers.iterator().next();
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getFirstName()).isNull();
        assertThat(customer.getLastName()).isNull();
    }

    @Test
    void testAllColumns() {
        Iterable<Customer> customers = customerRepository.findAll(0, 10, Sort.by(Sort.Direction.ASC, "id"), Collections.emptySet());

        assertThat(customers).hasSize(3);

        Customer customer = customers.iterator().next();
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getFirstName()).isNotNull();
        assertThat(customer.getLastName()).isNotNull();
    }
}
