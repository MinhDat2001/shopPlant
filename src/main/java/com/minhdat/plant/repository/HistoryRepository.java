package com.minhdat.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhdat.plant.domain.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

}
