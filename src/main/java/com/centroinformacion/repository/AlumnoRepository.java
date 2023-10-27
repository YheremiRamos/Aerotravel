package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	public abstract List<Alumno> findByOrderByApellidosAsc();
	
	@Query("select a from Alumno a where a.dni = ?1")
	public abstract List<Alumno> listaPorDniIgual(String dni);
	
	public List<Alumno> findByNombresOrApellidosIgnoreCase(String nombres, String apellidos);
	
	@Query("select a from Alumno a where a.nombres like ?1 or a.apellidos like ?1")
	public List<Alumno> listaPorNombresApellidosLike(String filtro);
	
	@Query("select a from Alumno a where a.nombres = ?1 and a.apellidos = ?2")
	public List<Alumno> listaAlumnoNombreApellidoIgualRegistra(String nombre, String apellido);
	
	@Query("select a from Alumno a where a.nombres = ?1 and a.apellidos = ?2 and a.idAlumno != ?3")
	public List<Alumno> listaAlumnoNombreApellidoIgualActualiza(String nombre, String apellido, int idAlumno);
	
	@Query("select a from Alumno a where a.dni = ?1 and a.idAlumno != ?2")
	public List<Alumno> listaAlumnoDniIgualActualiza(String dni, int idAlumno);
}
