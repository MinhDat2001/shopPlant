package com.minhdat.plant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.minhdat.plant.domain.Category;

public interface CategoryService {

	Category getById(Long id);

	void deleteAll();

	Category getOne(Long id);

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Category entity);

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	Optional<Category> findById(Long id);

	List<Category> findAll(Sort sort);

	List<Category> findAll();

	<S extends Category> S save(S entity);

}
