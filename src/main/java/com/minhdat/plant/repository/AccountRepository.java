package com.minhdat.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhdat.plant.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
