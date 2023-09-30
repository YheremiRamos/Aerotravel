package com.centroinformacion.service;
/**
 * @author Yheremi Ramos
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Libro;
import com.centroinformacion.repository.LibroRepository;


@Service
public class LibroServiceImp implements LibroService {
	@Autowired
	private LibroRepository repository;
	
	@Override
	public Libro insertaActualizaLibro(Libro obj) {
		return repository.save(obj);
	}

	@Override
	public List<Libro> listaPorNumeroSerie(String serie) {
		return repository.findBySerieIgnoreCase(serie);
	}
}