package com.centroinformacion.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Sala;
public interface SalaRepository extends JpaRepository<Sala, Integer> {
public abstract List<Sala> findByOrderByNumeroAsc();
public List<Sala> findByNumero(String numero);
public List<Sala> findByNumeroIgnoreCase(String numero);

@Query ("select a from Sala a where a.numero like?1 ")
public List<Sala> listaPorNumeroLike(String filtro);
@Query("select x from Sala x where x.numero = ?1")
public List<Sala> listaPorNumeroIgualRegistra(String numero);

@Query("select x from Sala x where x.numero = ?1 and x.idSala != ?2 ")

public List<Sala> listaPorNumeroIgualActualiza(String numero, int id);
}