package com.aereas.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aereas.domain.Aviao;
import com.aereas.domain.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {

	Voo findByAviaoAndEmbarqueAndChegada(Aviao aviao, Date embarque, Date chegada);

	@Query("SELECT obj FROM Voo obj WHERE obj.aviao = :aviao AND ((obj.embarque > :embarque AND obj.embarque < :chegada) OR (obj.chegada > :embarque AND obj.chegada < :chegada))")
	Voo findByAviaoAndHorario(Aviao aviao, Date embarque, Date chegada);

}
