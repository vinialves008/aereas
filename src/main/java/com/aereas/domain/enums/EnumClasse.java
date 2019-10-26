package com.aereas.domain.enums;

public enum EnumClasse {
	
	EXECUTIVA(1, "Classe Executiva"),
	ECONOMICA(2, "Classe Economica"),
	PRIMEIRA_CLASSE(3, "Primeira Classe");
	
	private Integer id;
	private String descricao;
	
	private EnumClasse(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static EnumClasse toEnum(Integer id) {
		if(id == null) {
			return null;
		}
			for (EnumClasse enumClasse : EnumClasse.values()) {
				if(id.equals(enumClasse.getId())) {
					return enumClasse;
				}
			}
		throw new IllegalArgumentException("Id invalido: "+id);
		
	}
	

}
