package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Editorial;

public interface EditorialService {

	public abstract Editorial insertaEditorial(Editorial obj);
	
	public abstract List<Editorial> listaPorRuc(String ruc);
	
	public abstract List<Editorial> listaPorRazonSocialLike(String filtro);
	public abstract Optional<Editorial> buscaEditorial(int idEditorial);
	
	
	
	
	
	public abstract List<Editorial> listaPorRucIgual(String ruc, int idEditorial);
	
	

}
