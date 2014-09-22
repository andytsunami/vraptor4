package br.com.caelum.vraptor.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.model.Usuario;

@Named("logado")
@SessionScoped
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = -1687898686784376042L;
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
