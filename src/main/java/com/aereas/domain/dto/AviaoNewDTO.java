package com.aereas.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.aereas.service.validations.AviaoInsert;

@AviaoInsert
public class AviaoNewDTO {

	@NotEmpty
	private String modelo;

	@NotEmpty
	@Length(max = 20, min = 3)
	private String marca;

	@NotNull
	private Integer totalDeAssentos;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getTotalDeAssentos() {
		return totalDeAssentos;
	}

	public void setTotalDeAssentos(Integer totalDeAssentos) {
		this.totalDeAssentos = totalDeAssentos;
	}

}
