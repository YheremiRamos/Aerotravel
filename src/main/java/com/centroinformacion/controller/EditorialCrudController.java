package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.service.EditorialService;

@Controller
public class EditorialCrudController {

	@Autowired
	private EditorialService editorialService;
	@ResponseBody
	@GetMapping("/consultaCrudEditorial")
	public List<Editorial> consulta(String filtro){
		List<Editorial> lstSalida = editorialService.listaPorRucLike("%"+filtro+"%");
		return lstSalida;
		
	}
}
