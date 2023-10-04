package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Tesis;

public interface TesisService {

	public abstract Tesis insertaActualizaTesis(Tesis obj);
	/*public abstract Tesis insertaTesis(Tesis obj);*/
	public abstract List<Tesis> listaPorTituloOrTema(String titulo, String tema);
	public abstract List<Tesis>listaPorTituloLike(String filtro);

}
