package com.aereas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aereas.domain.Aviao;
import com.aereas.repository.AviaoRepository;
import com.aereas.service.exceptions.ObjectNotFoundException;

@Service
public class AviaoService {

	@Autowired
	private AviaoRepository repo;

	public void save(Aviao aviao) {
		repo.save(aviao);
	}

	public Aviao findById(Integer id) {
		Optional<Aviao> oaviao = repo.findById(id);
		return oaviao.orElseThrow(() -> new ObjectNotFoundException("Avião não Encontrado!!"));
	}

	public List<Aviao> findAll() {
		return repo.findAll();
	}

	public void update(Aviao aviao) {
		Aviao ant = this.findById(aviao.getId());

		updateData(aviao, ant);

		repo.save(ant);
	}

	private void updateData(Aviao aviao, Aviao ant) {
		ant.setMarca(aviao.getMarca() == null ? ant.getMarca() : aviao.getMarca());
		ant.setModelo(aviao.getModelo() == null ? ant.getModelo() : aviao.getModelo());
		ant.setTotalDeAssentos(
				aviao.getTotalDeAssentos() == null ? ant.getTotalDeAssentos() : aviao.getTotalDeAssentos());
	}

	public void delete(Integer id) {
		Aviao aviao = this.findById(id);
		try {
			repo.delete(aviao);
		} catch (DataIntegrityViolationException e) {
			throw new com.aereas.service.exceptions.DataIntegrityViolationException(
					"Este Avião está associado a Voos e por isso não pode ser excluído!!!");
		}
	}

	public Boolean findByModelo(String modelo) {
		Aviao aviao = repo.findByModelo(modelo);
		return aviao == null ? false : true;
	}

}
