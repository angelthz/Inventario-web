package com.athz.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@Column(name="pk_categoria")
	private Integer idCategoria;
	private String nombre;
	
	
	//relacionamiento bidireccional
	@OneToMany (mappedBy = "categoria")
	private List<Producto> productos; 
	
	public Categoria() {
		
	}
	
	

	/**
	 * @param nombre
	 */
	public Categoria(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @param idCategoria
	 * @param nombre
	 */
	public Categoria(Integer idCategoria, String nombre) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}



	public Categoria(Integer idCat) {
		this.idCategoria = idCat;
	}



	/**
	 * @return the idCategoria
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}



	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	@Override
	public String toString() {
		return nombre;
	}
	
	//
	
}
