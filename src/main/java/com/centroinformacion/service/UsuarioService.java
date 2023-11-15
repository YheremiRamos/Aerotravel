package com.centroinformacion.service;

import com.centroinformacion.entity.Usuario;

public interface UsuarioService {

	public abstract Usuario login(Usuario bean);

	public abstract Usuario buscaPorLogin(String usuario);
}
