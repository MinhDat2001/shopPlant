package com.minhdat.plant.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.minhdat.plant.domain.History;
import com.minhdat.plant.repository.HistoryRepository;
import com.minhdat.plant.service.HistoryService;
@Service
public class HistoryServiceImpl implements HistoryService {
	HistoryRepository historyRepository;

	public HistoryServiceImpl(HistoryRepository historyRepository) {
		super();
		this.historyRepository = historyRepository;
	}

	@Override
	public <S extends History> S save(S entity) {
		return historyRepository.save(entity);
	}

	@Override
	public List<History> findAll() {
		return historyRepository.findAll();
	}

	@Override
	public List<History> findAll(Sort sort) {
		return historyRepository.findAll(sort);
	}

	@Override
	public boolean existsById(Long id) {
		return historyRepository.existsById(id);
	}

	@Override
	public <S extends History> Page<S> findAll(Example<S> example, Pageable pageable) {
		return historyRepository.findAll(example, pageable);
	}

	@Override
	public long count() {
		return historyRepository.count();
	}

	@Override
	public <S extends History> boolean exists(Example<S> example) {
		return historyRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		historyRepository.deleteById(id);
	}

	@Override
	public void delete(History entity) {
		historyRepository.delete(entity);
	}

	@Override
	public History getOne(Long id) {
		return historyRepository.getOne(id);
	}

	@Override
	public void deleteAll() {
		historyRepository.deleteAll();
	}

	@Override
	public History getById(Long id) {
		return historyRepository.getById(id);
	}
	
}
