package com.centroinformacion.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Libro;

/**
 * @author Yheremi Ramos
 */
public interface LibroRepository extends JpaRepository<Libro, Integer>  {

	public List<Libro> findBySerieIgnoreCase(String serie);
	
	public List<Libro> findByTituloOrSerieIgnoreCase(String titulo,String serie);
	
	public List<Libro> findByTitulo(String titulo);
	public List<Libro> findBySerie(String serie);
	
	@Query("select p from Libro p where p.titulo like ?1")
	public List<Libro> listPorTituloLike(String filtro);
	
	@Query("select a from Libro a where a.titulo = ?1 and a.idLibro != ?2")
	public List<Libro> listaPorTituloActualizar(String titulo,  int idLibro);

	
	
	@Query("select a from Libro a where a.serie = ?1 and a.idLibro != ?2")
	public List<Libro> listaPorSerieActualizar(String serie, int idLibro);

}
