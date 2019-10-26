package com.aereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aereas.domain.Aviao;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Integer> {

	Aviao findByModelo(String modelo);
	

}
