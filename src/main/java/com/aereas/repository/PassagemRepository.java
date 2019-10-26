package com.aereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aereas.domain.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}
