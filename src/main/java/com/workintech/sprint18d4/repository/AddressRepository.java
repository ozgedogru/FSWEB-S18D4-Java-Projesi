package com.workintech.sprint18d4.repository;

import com.workintech.sprint18d4.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
