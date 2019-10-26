package com.aereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aereas.domain.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

}
