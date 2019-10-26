package com.aereas.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.aereas.domain.enums.EnumClasse;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PassagemPK id;

	private Integer classe;

	private Double preco;

	public PassagemPK getId() {
		return id;
	}

	public void setId(PassagemPK id) {
		this.id = id;
	}

	public EnumClasse getClasse() {
		return EnumClasse.toEnum(classe);
	}

	public void setClasse(EnumClasse classe) {
		this.classe = classe.getId();
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
