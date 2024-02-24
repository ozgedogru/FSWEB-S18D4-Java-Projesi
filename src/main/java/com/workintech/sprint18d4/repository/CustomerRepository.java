package com.workintech.sprint18d4.repository;

import com.workintech.sprint18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
