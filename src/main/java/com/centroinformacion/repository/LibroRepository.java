package com.centroinformacion.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Libro;

/**
 * @author Yheremi Ramos
 */



public interface LibroRepository extends JpaRepository<Libro, Integer>  {

	List<Libro> findBySerieIgnoreCase(String serie);

}
