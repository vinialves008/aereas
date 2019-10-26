package com.aereas;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aereas.domain.Aviao;
import com.aereas.domain.dto.AviaoNewDTO;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public void addMappers() {
		modelMapper().getConfiguration().setSkipNullEnabled(true);
		
		PropertyMap<AviaoNewDTO, Aviao> newAviaoMap = new PropertyMap<AviaoNewDTO, Aviao>() {
			@Override
			protected void configure() {
				map().setMarca(source.getMarca());
				map().setModelo(source.getModelo());
				map().setTotalDeAssentos(source.getTotalDeAssentos());
				
			}
		};
		modelMapper().addMappings(newAviaoMap);

	}
}
