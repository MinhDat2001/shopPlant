package com.minhdat.plant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.minhdat.plant.domain.Product;

public interface ProductService {

	Product getById(Long id);

	void deleteAll();

	void delete(Product entity);

	void deleteById(Long id);

	<S extends Product> boolean exists(Example<S> example);

	long count();

	boolean existsById(Long id);

	Optional<Product> findById(Long id);

	List<Product> findAll(Sort sort);

	List<Product> findAll();

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> S save(S entity);


}
