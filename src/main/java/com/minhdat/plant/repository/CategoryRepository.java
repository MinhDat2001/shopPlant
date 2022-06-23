package com.minhdat.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhdat.plant.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
