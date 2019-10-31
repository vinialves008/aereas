package com.aereas.domain.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.aereas.service.validations.VooInsert;

@VooInsert
public class VooNewDTO {

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date embarque;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date chegada;

	@NotNull
	private Integer aviao;

	public Date getEmbarque() {
		return embarque;
	}

	public void setEmbarque(Date embarque) {
		this.embarque = embarque;
	}

	public Date getChegada() {
		return chegada;
	}

	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}

	public Integer getAviao() {
		return aviao;
	}

	public void setAviao(Integer aviao) {
		this.aviao = aviao;
	}

}
