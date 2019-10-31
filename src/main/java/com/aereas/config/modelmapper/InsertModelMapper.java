package com.aereas.config.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aereas.domain.Aviao;
import com.aereas.domain.Voo;
import com.aereas.domain.dto.AviaoNewDTO;
import com.aereas.domain.dto.VooNewDTO;

@Configuration
public class InsertModelMapper {

	@Autowired
	private ModelMapper modelMapper;

	@Bean
	public void addInsertMapper() {

		PropertyMap<AviaoNewDTO, Aviao> newAviaoMap = new PropertyMap<AviaoNewDTO, Aviao>() {
			@Override
			protected void configure() {
				map().setMarca(source.getMarca());
				map().setModelo(source.getModelo());
				map().setTotalDeAssentos(source.getTotalDeAssentos());
			}
		};
		modelMapper.addMappings(newAviaoMap);
		
		PropertyMap<VooNewDTO, Voo> newVooMap = new PropertyMap<VooNewDTO, Voo>() {
			@Override
			protected void configure() {
				map().setChegada(source.getChegada());
				map().setEmbarque(source.getEmbarque());
				map().getAviao().setId(source.getAviao());
			}
		};
		modelMapper.addMappings(newVooMap);

	}

}
