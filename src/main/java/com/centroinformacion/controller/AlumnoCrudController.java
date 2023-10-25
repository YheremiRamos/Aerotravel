package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.AlumnoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AlumnoCrudController {

	@Autowired
	private AlumnoService alumnoService;
	
	@ResponseBody
	@GetMapping("/consultaCrudAlumno")
	public List<Alumno> consulta(String filtro){
		List<Alumno> lstSalida = alumnoService.listaPorNombresApellidosLike("%"+filtro+"%");
		return lstSalida;
	}
	
	@PostMapping("/registraCrudAlumno")
	@ResponseBody
	public Map<?, ?> registra(Alumno obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Usuario objUsuario = (Usuario)session.getAttribute("objUsuario");
		obj.setEstado(1);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		obj.setUsuarioRegistro(objUsuario);
		obj.setUsuarioActualiza(objUsuario);
		
		List<Alumno> lstSalida = alumnoService.
						listaPorNombresOrApellidos(
								obj.getNombres(), 
								obj.getApellidos());
		if (!CollectionUtils.isEmpty(lstSalida)) {
			map.put("mensaje", "El alumno " + obj.getNombres() + " " + obj.getApellidos() + " ya existe");
			return map;
		}
		
		Alumno objSalida = alumnoService.insertaActualizaAlumno(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			List<Alumno> lista = alumnoService.listaPorNombresApellidosLike("%");
			map.put("lista", lista);
			map.put("mensaje", "Registro exitoso");
		}
		return map;
	}
	
	@PostMapping("/actualizaCrudAlumno")
	@ResponseBody
	public Map<?, ?> actualiza(Alumno obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		  
		Optional<Alumno> optAlumno= alumnoService.buscaAlumno(obj.getIdAlumno());
		obj.setFechaRegistro(optAlumno.get().getFechaRegistro());
		obj.setFechaActualizacion(optAlumno.get().getFechaActualizacion());
		obj.setEstado(optAlumno.get().getEstado());
		obj.setUsuarioRegistro(optAlumno.get().getUsuarioRegistro());
		obj.setUsuarioActualiza(optAlumno.get().getUsuarioActualiza());
		
		Alumno objSalida = alumnoService.insertaActualizaAlumno(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Alumno> lista = alumnoService.listaPorNombresApellidosLike("%");
			map.put("lista", lista);
			map.put("mensaje", "Actualización exitosa");
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping("/eliminaCrudAlumno")
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Alumno objEmpleado= alumnoService.buscaAlumno(id).get();
		objEmpleado.setEstado( objEmpleado.getEstado() == 1 ? 0 : 1);
		Alumno objSalida = alumnoService.insertaActualizaAlumno(objEmpleado);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Alumno> lista = alumnoService.listaPorNombresApellidosLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	
	
}
