package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<Alumno> listaTodos() {
		return repository.findByOrderByApellidosAsc();
	}

	@Override
	public Alumno insertaActualizaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public List<Alumno> listaPorDniIgual(String dni) {
		return repository.listaPorDniIgual(dni);
	}

	@Override
	public List<Alumno> listaPorNombresOrApellidos(String nombres, String apellidos) {
		return repository.findByNombresOrApellidosIgnoreCase(nombres,apellidos);
	}

	@Override
	public List<Alumno> listaPorNombresApellidosLike(String filtro) {
		return repository.listaPorNombresApellidosLike(filtro);
	}

	@Override
	public Optional<Alumno> buscaAlumno(int idAlumno) {
		return repository.findById(idAlumno);
	}

	@Override
	public List<Alumno> listaPorNombreApellidoIgualRegistra(String nombre, String apellido) {
		return repository.listaAlumnoNombreApellidoIgualRegistra(nombre, apellido); 
	}

	@Override
	public List<Alumno> listaPorNombreApellidoIgualActualiza(String nombre, String apellido, int idAlumno) {
		return repository.listaAlumnoNombreApellidoIgualActualiza(nombre, apellido, idAlumno);
	}

	@Override
	public List<Alumno> listaPorDniIgualActualiza(String dni, int idAlumno) {
		return repository.listaAlumnoDniIgualActualiza(dni, idAlumno);
	}
	
	
}
