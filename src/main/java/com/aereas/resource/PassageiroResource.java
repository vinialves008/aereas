package com.aereas.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aereas.domain.Passageiro;
import com.aereas.service.PassageiroService;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

	@Autowired
	private PassageiroService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Passageiro dto){
		service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Passageiro> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Passageiro>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
}
