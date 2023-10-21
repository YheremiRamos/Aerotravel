package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	public abstract List<Alumno> findByOrderByApellidosAsc();
	public List<Alumno> findByDni(String dni);
	
	public List<Alumno> findByNombresOrApellidosIgnoreCase(String nombres, String apellidos);
	
	@Query("select a from Alumno a where a.nombres like ?1 or a.apellidos like ?1")
	public List<Alumno> listaPorNombresApellidosLike(String filtro);
	
}
