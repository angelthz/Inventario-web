package com.athz.jpa.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="pk_producto")
	private Integer idProducto;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="fk_categoria")
	private Categoria categoria;
	
	private String nombre;
	private BigDecimal precio;
	private Integer cantidad;
	
	//Default constructor
	public Producto() {
		
	}
	
	

	/**
	 * @param idProducto
	 * @param categoria
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 */
	public Producto(Integer idProducto, Categoria categoria, String nombre, BigDecimal precio, Integer cantidad) {
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	

	/**
	 * @param categoria
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 */
	public Producto(Categoria categoria, String nombre, BigDecimal precio, Integer cantidad) {
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Producto(String nombre, BigDecimal precio, Integer cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Producto(Integer id, String nombre, BigDecimal precio, Integer cantidad) {
		this.idProducto = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}


	public Producto(Integer idCat, String nombre, Integer cantidad, BigDecimal precio) {
		this.categoria = new Categoria(idCat);
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}



	/**
	 * @return the idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", categoria=" + categoria.getIdCategoria() + ", nombre=" + nombre + ", precio="
				+ precio + ", cantidad=" + cantidad + "]";
	}
	
	//
	
}
