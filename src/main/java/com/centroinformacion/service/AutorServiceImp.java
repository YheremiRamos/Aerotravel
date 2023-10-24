package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

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
	public List<Autor> listaPorTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}

	
	@Override
	public List<Autor> listaPorNombresOrApellidos(String nombres, String apellidos) {
		return repository.findByNombresOrApellidosIgnoreCase(nombres,apellidos);
	}
	@Override
	public List<Autor> listaPorNombresApellidosLike(String filtro) {
		return repository.listaPorNombresApellidosLike(filtro);
	}

	@Override
	public Optional<Autor> buscaAutor(int idAutor) {
		return repository.findById(idAutor);
	}

	@Override
	public List<Autor> listaPorNombreApellidoIgual(String nombres, String apellidos) {
		return repository.listaAutorNombreApellidoIgual(nombres, apellidos);

	}

	@Override
	public List<Autor> listaPorNombreApellidoIgualActualiza(String nombres, String apellidos, int idAutor) {
		return repository.listaAutorNombreApellidoIgualActualiza(nombres, apellidos, idAutor);
	}

	@Override
	public List<Autor> listaPorTelefonoIgual(String telefono, int idAutor) {
		return repository.listaAutorTelefonoIgualActualiza(telefono, idAutor);
	}
	

	
	
	 
}


