package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Libro;

public interface LibroService {
	
	
	public abstract Libro insertaActualizaLibro(Libro obj);
	public abstract List<Libro> listaPorSerie(String serie);
	public abstract List<Libro> listaPorTitulo(String titulo);
	public abstract Optional<Libro> buscaTitulo(int titulo);
	public abstract List<Libro> listaPorTituloOrSerie(String titulo, String serie);
	public abstract List<Libro> listaPorTituloLike(String filtro);
	
}
