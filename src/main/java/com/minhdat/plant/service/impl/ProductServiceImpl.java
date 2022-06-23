package com.minhdat.plant.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.minhdat.plant.domain.Product;
import com.minhdat.plant.repository.productRepository;
import com.minhdat.plant.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	productRepository productRP;

	public ProductServiceImpl(productRepository productRP) {
		super();
		this.productRP = productRP;
	}

	@Override
	public <S extends Product> S save(S entity) {
		return productRP.save(entity);
	}

	@Override
	public <S extends Product> Optional<S> findOne(Example<S> example) {
		return productRP.findOne(example);
	}

	@Override
	public List<Product> findAll() {
		return productRP.findAll();
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productRP.findAll(sort);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRP.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return productRP.existsById(id);
	}

	@Override
	public long count() {
		return productRP.count();
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productRP.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		productRP.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productRP.delete(entity);
	}

	@Override
	public void deleteAll() {
		productRP.deleteAll();
	}

	@Override
	public Product getById(Long id) {
		return productRP.getById(id);
	}

	
}
