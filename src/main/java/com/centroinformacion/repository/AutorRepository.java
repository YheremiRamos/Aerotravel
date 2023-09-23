package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Autor;

public interface AutorRepository  extends JpaRepository<Autor, Integer> {

	/*Buscar por nombre ignorando las mayuscula y miniscula*/
	public List<Autor> findByTelefonoIgnoreCase(String telefono);


}
