package com.minhdat.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhdat.plant.domain.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

}
