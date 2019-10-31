package com.aereas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aereas.domain.Aviao;
import com.aereas.domain.Voo;
import com.aereas.repository.VooRepository;
import com.aereas.service.exceptions.ObjectNotFoundException;

@Service
public class VooService {

	@Autowired
	private VooRepository repo;

	public void save(Voo voo) {
		repo.save(voo);
	}

	public Voo findById(Integer id) {
		Optional<Voo> ovoo = repo.findById(id);
		return ovoo.orElseThrow(() -> new ObjectNotFoundException("Voo não Encontrado!!"));
	}

	public List<Voo> findAll() {
		return repo.findAll();
	}

	public void update(Voo voo) {
		Voo ant = this.findById(voo.getId());

		updateData(voo, ant);

		repo.save(ant);
	}

	private void updateData(Voo voo, Voo ant) {

	}

	public void delete(Integer id) {
		Voo voo = this.findById(id);
		try {
			repo.delete(voo);
		} catch (DataIntegrityViolationException e) {
			throw new com.aereas.service.exceptions.DataIntegrityViolationException(
					"Este Avião está associado a Voos e por isso não pode ser excluído!!!");
		}
	}

	public Voo findByVoo(Aviao aviao, Date embarque, Date chegada) {
		return repo.findByAviaoAndEmbarqueAndChegada(aviao, embarque, chegada);
	}

	public Voo findByAviaoAndStartDateBetween(Aviao aviao, Date embarque, Date chegada) {
		return repo.findByAviaoAndHorario(aviao, embarque, chegada);
	}

}
