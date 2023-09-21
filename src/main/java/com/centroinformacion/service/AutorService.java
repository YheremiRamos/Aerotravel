package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Autor;

public interface AutorService {

	
	public abstract Autor insertaActualizaAutor(Autor obj);
	public abstract List<Autor> listaPorNombres(String nombres);
	public abstract List<Autor> listaPorApellidos(String apellidos);

	
}
