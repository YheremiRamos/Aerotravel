package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.repository.AutorRepository;

@Service

public class AutorServiceImp implements AutorService{


	@Autowired
	private AutorRepository repository;

	@Override
	public Autor insertaActualizaAutor(Autor obj) {
		return repository.save(obj);
	}

	@Override
	public List<Autor> listaPorNombres(String nombres) {
		return repository.findByNombresIgnoreCase(nombres);
	}

	@Override
	public List<Autor> listaPorApellidos(String apellidos) {
		return repository.findByApellidosIgnoreCase(apellidos);
	}
}
