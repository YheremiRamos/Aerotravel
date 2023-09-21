package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Tesis;

public interface TesisRepository extends JpaRepository<Tesis, Integer> {
	public List<Tesis> findByTituloOrTemaIgnoreCase(String titulo, String tema);
	}
