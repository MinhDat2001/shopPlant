package com.minhdat.plant.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.minhdat.plant.domain.Cart;
import com.minhdat.plant.repository.CartRepository;
import com.minhdat.plant.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}

	@Override
	public <S extends Cart> S save(S entity) {
		return cartRepository.save(entity);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public List<Cart> findAll(Sort sort) {
		return cartRepository.findAll(sort);
	}

	@Override
	public <S extends Cart> List<S> saveAll(Iterable<S> entities) {
		return cartRepository.saveAll(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return cartRepository.existsById(id);
	}

	@Override
	public long count() {
		return cartRepository.count();
	}

	@Override
	public <S extends Cart> boolean exists(Example<S> example) {
		return cartRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		cartRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void deleteAll() {
		cartRepository.deleteAll();
	}
	

}
