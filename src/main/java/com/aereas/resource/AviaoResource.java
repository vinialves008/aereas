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

import com.aereas.domain.Aviao;
import com.aereas.domain.dto.AviaoNewDTO;
import com.aereas.service.AviaoService;

@RestController
@RequestMapping(value = "/aviao")
public class AviaoResource {

	@Autowired
	private AviaoService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody AviaoNewDTO dto){
		Aviao aviao = modelMapper.map(dto, Aviao.class);
		service.save(aviao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aviao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Aviao> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Aviao>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
