package com.aereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aereas.domain.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {

}
