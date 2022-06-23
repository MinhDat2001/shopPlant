package com.minhdat.plant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.minhdat.plant.domain.Customer;

public interface CustomerService {

	Customer getById(Long id);

	void deleteAll();

	Customer getOne(Long id);

	void delete(Customer entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	<S extends Customer> List<S> saveAll(Iterable<S> entities);

	Optional<Customer> findById(Long id);

	List<Customer> findAll(Sort sort);

	List<Customer> findAll();

	<S extends Customer> S save(S entity);

}
