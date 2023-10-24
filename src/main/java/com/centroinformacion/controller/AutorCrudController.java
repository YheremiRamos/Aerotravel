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

	@GetMapping("/consultaCrudAutor")
	@ResponseBody

	public List<Autor> consulta(String filtro){
	 List<Autor>  listSalida =autorService.listaPorNombreLike("%"+filtro+"%");
	
	 return listSalida;
	}


	@PostMapping("/registraCrudAutor")
	@ResponseBody

	public Map<?, ?> registraCrud(Autor obj, HttpSession session){
		HashMap<String, Object> map = new HashMap<String, Object>();

		Usuario objUsuario = (Usuario)session.getAttribute("objUsuario");
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		obj.setEstado(AppSettings.ACTIVO);
		obj.setUsuarioRegistro(objUsuario);
		obj.setUsuarioActualiza(objUsuario);

		Autor objSalida = autorService.insertaActualizaAutor(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		}else {
			map.put("mensaje", "Registro exitoso");
		}
		return map;
	}
	
	
	



	@PostMapping("/actualizaCrudAutor")
	@ResponseBody

	public Map<?, ?> actualiza(Autor obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		

		Optional<Autor> optAutor = autorService.buscaAutor(obj.getIdAutor());
		if (optAutor.isPresent()) {
			
			obj.setFechaRegistro(optAutor.get().getFechaRegistro());
			obj.setEstado(optAutor.get().getEstado());
			obj.setFechaActualizacion(new Date());
			obj.setUsuarioRegistro(optAutor.get().getUsuarioRegistro());
			obj.setUsuarioActualiza(optAutor.get().getUsuarioActualiza());

			Autor objSalida = autorService.insertaActualizaAutor(obj);
			if (objSalida == null) {
				map.put("mensaje", "Error en la actualización");
			} else {
				map.put("mensaje", "Actualización exitosa");
				List<Autor> lstSalida = autorService.listaPorNombreLike("%");
				map.put("lista", lstSalida);

			}
		}
		return map;
	}




	

	@PostMapping("/eliminaCrudAutor")
	@ResponseBody

	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Autor objAutor= autorService.buscaAutor(id).get();
		objAutor.setFechaActualizacion(new Date());  
		/*1= activo : 0=iNACTIVO*/
		objAutor.setEstado( objAutor.getEstado() == 1 ? 0 : 1);
		Autor objSalida = autorService.insertaActualizaAutor(objAutor);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Autor> lista = autorService.listaPorNombreLike("%");
			map.put("lista", lista);
		}
		return map;
	}

}




