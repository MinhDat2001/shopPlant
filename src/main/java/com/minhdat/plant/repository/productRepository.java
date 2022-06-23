package com.minhdat.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhdat.plant.domain.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Long> {

}
