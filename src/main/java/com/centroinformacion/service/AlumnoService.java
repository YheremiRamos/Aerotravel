package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaTodos();
	
	public abstract Alumno insertaActualizaAlumno(Alumno obj);
	public abstract List<Alumno> listaPorDni(String dni);
	
	public abstract List<Alumno> listaPorNombresOrApellidos(String nombres, String apellidos);
	public abstract List<Alumno> listaPorNombresLike(String filtro);

}
