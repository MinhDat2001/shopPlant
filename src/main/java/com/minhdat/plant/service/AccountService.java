package com.minhdat.plant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.minhdat.plant.domain.Account;

public interface AccountService {

	Account getById(String id);

	void deleteAll();

	void delete(Account entity);

	void deleteById(String id);

	<S extends Account> boolean exists(Example<S> example);

	long count();

	<S extends Account> long count(Example<S> example);

	boolean existsById(String id);

	<S extends Account> List<S> saveAll(Iterable<S> entities);

	Optional<Account> findById(String id);

	List<Account> findAll(Sort sort);

	List<Account> findAll();

	<S extends Account> S save(S entity);

}
