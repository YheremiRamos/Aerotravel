package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Autor;

public interface AutorService {

	
	public abstract Autor insertaActualizaAutor(Autor obj);
	public abstract List<Autor> listaPorTelefono(String telefono);

	public abstract List<Autor>listaPorNombreLike(String filtro);

	
	

	/*Encapsula un objeto, java util*/
	public abstract Optional<Autor>buscaAutor(int idAutor);
}
