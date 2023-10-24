package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Autor;

public interface AutorRepository  extends JpaRepository<Autor, Integer> {

	/*Buscar por nombre ignorando las mayuscula y miniscula*/
	public List<Autor> findByTelefono(String telefono);

     /*Crear Query  JSPQL*/
	@Query("Select a from Autor a where a.nombres like?1 or a.apellidos like?1")
	public List<Autor>listaPorNombreLike(String filtro);
	
	
	
}
