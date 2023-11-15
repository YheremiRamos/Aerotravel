package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	@Query("Select x from Usuario x where x.usuario = :#{#usu.usuario} and x.contra = :#{#usu.contra}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	public abstract Usuario findByUsuario(String usuario);
	
}
