package com.centroinformacion.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Libro;

/**
 * @author Yheremi Ramos
 */
public interface LibroRepository extends JpaRepository<Libro, Integer>  {

	public List<Libro> findBySerieIgnoreCase(String serie);
	
	@Query("select p.titulo from Libro p where p.titulo like ?1")
	public List<Libro> listPorTituloLike(String filtro);
	
	
}
