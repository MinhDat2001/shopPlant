package com.minhdat.plant.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.minhdat.plant.domain.History;

public interface HistoryService {

	History getById(Long id);

	void deleteAll();

	History getOne(Long id);

	void delete(History entity);

	void deleteById(Long id);

	<S extends History> boolean exists(Example<S> example);

	long count();

	<S extends History> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(Long id);

	List<History> findAll(Sort sort);

	List<History> findAll();

	<S extends History> S save(S entity);

}
