package com.centroinformacion.repository;
/**
 * @author Yheremi Ramos
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Libro;


public interface LibroRepository extends JpaRepository<Libro, Integer>  {

}
