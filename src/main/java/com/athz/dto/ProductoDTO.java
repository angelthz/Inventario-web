package com.athz.dto;

import java.math.BigDecimal;

import com.athz.jpa.entities.Producto;

public class ProductoDTO {
	private Integer id;
	private String nombre;
	private BigDecimal precio;
	private Integer cantidad;
	private CategoriaDTO categoria;
	
	public ProductoDTO() {
		
	}
	
	public ProductoDTO(Producto prod) {
		this.id = prod.getIdProducto();
		this.nombre = prod.getNombre();
		this.precio = prod.getPrecio();
		this.cantidad = prod.getCantidad();
		this.categoria = new CategoriaDTO(prod.getCategoria());
	}
	
}
