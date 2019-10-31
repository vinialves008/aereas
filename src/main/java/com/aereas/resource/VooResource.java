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

import com.aereas.domain.Voo;
import com.aereas.domain.dto.VooNewDTO;
import com.aereas.service.VooService;

@RestController
@RequestMapping(value = "/voo")
public class VooResource {

	@Autowired
	private VooService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody VooNewDTO dto){
		Voo voo = modelMapper.map(dto, Voo.class);
		service.save(voo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(voo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Voo> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Voo>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
