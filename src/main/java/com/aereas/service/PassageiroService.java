package com.aereas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aereas.domain.Passageiro;
import com.aereas.domain.enums.Perfil;
import com.aereas.repository.PassageiroRepository;
import com.aereas.service.exceptions.ObjectNotFoundException;

@Service
public class PassageiroService {

	@Autowired
	private PassageiroRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public void save(Passageiro passageiro) {
		passageiro.addPerfil(Perfil.CLIENTE);
		passageiro.setPassword(pe.encode(passageiro.getPassword()));
		repo.save(passageiro);
	}

	public Passageiro findById(Integer id) {
		Optional<Passageiro> opassageiro = repo.findById(id);
		return opassageiro.orElseThrow(() -> new ObjectNotFoundException("Passageiro não Encontrado!!"));
	}

	public List<Passageiro> findAll() {
		return repo.findAll();
	}

	public void update(Passageiro passageiro) {
		Passageiro ant = this.findById(passageiro.getId());

		updateData(passageiro, ant);

		repo.save(ant);
	}

	private void updateData(Passageiro passageiro, Passageiro ant) {
		
	}

	public void delete(Integer id) {
		Passageiro passageiro = this.findById(id);
		try {
			repo.delete(passageiro);
		} catch (DataIntegrityViolationException e) {
			throw new com.aereas.service.exceptions.DataIntegrityViolationException(
					"Este Passageiro não pode ser excluído!!!");
		}
	}

	

}
