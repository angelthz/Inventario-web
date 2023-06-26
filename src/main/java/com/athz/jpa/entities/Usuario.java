package com.athz.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;
	private String usuario;
	private String pass;
	
	public Usuario() {
		
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
}
