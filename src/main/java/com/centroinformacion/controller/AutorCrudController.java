package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.AutorService;
import com.centroinformacion.util.AppSettings;

import jakarta.servlet.http.HttpSession;

@Controller
public class AutorCrudController {

	@Autowired
	private AutorService autorService;

	@ResponseBody
	@GetMapping("/consultaCrudAutor")
	public List<Autor> consulta(String filtro){
	 List<Autor>  listSalida =autorService.listaPorNombreLike("%"+filtro+"%");
	
	 return listSalida;
	}



	@PostMapping("/registraCrudAutor")
	@ResponseBody
	public Map<?, ?> registra(Autor obj, HttpSession session){
		Usuario objUsuario = (Usuario)session.getAttribute("objUsuario");
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		obj.setEstado(AppSettings.ACTIVO);
		obj.setUsuarioRegistro(objUsuario);
		obj.setUsuarioActualiza(objUsuario);
		
		HashMap<String, String> map = new HashMap<String, String>();
		Autor objSalida = autorService.insertaActualizaAutor(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		}else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	
	
	
	@PostMapping("/actualizaCrudAutor")
	@ResponseBody
	public Map<?, ?> actualiza(Autor obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Optional<Autor> optAutor = autorService.buscaAutor(obj.getIdAutor());
		if (optAutor.isPresent()) {
			obj.setFechaActualizacion(new Date());
			obj.setFechaRegistro(optAutor.get().getFechaRegistro());
			obj.setEstado(optAutor.get().getEstado());
			Autor objSalida = autorService.insertaActualizaAutor(obj);
			if (objSalida == null) {
				map.put("mensaje", "Error en la actualización");
			} else {
				List<Autor> lstSalida = autorService.listaPorNombreLike("%");
				map.put("lista", lstSalida);
				map.put("mensaje", "Actualizacón exitosa");
			}
		}
		return map;
	}
	
	
	
	@ResponseBody
	@PostMapping("/eliminaCrudAutor")
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Autor objModalidad= autorService.buscaAutor(id).get();
		objModalidad.setFechaActualizacion(new Date());  
		/*1= activo : 0=iNACTIVO*/
		objModalidad.setEstado( objModalidad.getEstado() == 1 ? 0 : 1);
		Autor objSalida = autorService.insertaActualizaAutor(objModalidad);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Autor> lista = autorService.listaPorNombreLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	




}

