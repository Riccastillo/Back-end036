package com.backend.app.oauth.service;
import com.backend.app.commons.users.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
