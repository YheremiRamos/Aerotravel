package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
	
	public List<Editorial> findByRuc(String ruc);
	
	
	
	@Query("select p from Editorial p where p.ruc like ?1")
	public List<Editorial> listaPorRucLike(String filtro);


}
