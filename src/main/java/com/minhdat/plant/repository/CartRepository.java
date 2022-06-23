package com.minhdat.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhdat.plant.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
