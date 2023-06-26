package com.athz.dto;

import com.athz.jpa.entities.Categoria;

public class CategoriaDTO {
	private Integer id;
	private String nombre;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria cat) {
		this.id = cat.getIdCategoria();
		this.nombre = cat.getNombre();
	}
}
