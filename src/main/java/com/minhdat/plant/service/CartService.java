package com.minhdat.plant.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.minhdat.plant.domain.Cart;

public interface CartService {

	void deleteAll();

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Cart> boolean exists(Example<S> example);

	long count();

	boolean existsById(Long id);

	<S extends Cart> List<S> saveAll(Iterable<S> entities);

	List<Cart> findAll(Sort sort);

	List<Cart> findAll();

	<S extends Cart> S save(S entity);

}
