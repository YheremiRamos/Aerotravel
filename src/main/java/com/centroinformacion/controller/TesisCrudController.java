package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Tesis;
import com.centroinformacion.service.TesisService;

@Controller
public class TesisCrudController {
	
	@Autowired
	private TesisService tesisService;
	
	@ResponseBody
	@GetMapping("/consultaCrudTesis")
	public List<Tesis> consulta(String filtro){
		 List<Tesis> lstSalida = tesisService.listaPorTituloLike("%"+filtro+"%");
		 return lstSalida;
	}
	
	/*@PostMapping("/registraCrudTesis")
	@ResponseBody
	public Map<?, ?> registra(Tesis obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		obj.setFechaRegistro(new Date()); 
		obj.setFechaActualizacion(new Date());  
		Tesis objSalida = tesisService.insertaTesis(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			List<Tesis> lista = tesisService.listaPorTituloLike("%");
			map.put("lista", lista);
			map.put("mensaje", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorTituloOrTemaTesis")
	@ResponseBody
	public String validaTituloOrTema(String titulo, String tema) {
		List<Tesis> lstTesis = tesisService.listaPorTituloOrTema(titulo, tema);
		if (CollectionUtils.isEmpty(lstTesis)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}*/
}
