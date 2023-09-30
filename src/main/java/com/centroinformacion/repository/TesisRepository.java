package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Tesis;

public interface TesisRepository extends JpaRepository<Tesis, Integer> {
	public List<Tesis> findByTituloOrTemaIgnoreCase(String titulo, String tema);
	
	@Query("select p from Tesis p where p.titulo like ?1")
	public List<Tesis> listaPorTituloLike(String filtro);
	}
