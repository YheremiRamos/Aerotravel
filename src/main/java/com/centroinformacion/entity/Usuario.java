package com.centroinformacion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idcliente;
	private String nombre;
	private String apellido;
	private String correo;
	private int dni;
	private int telefono;
	private String usuario;
	private String contra;
	/*
	public String getNombreCompleto() {
		return nombres.concat(" ").concat(apellidos);
	}*/
}
