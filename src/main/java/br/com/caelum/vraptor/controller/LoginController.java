package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;

@Controller
public class LoginController {
	
	private final Result result;
	
	private final UsuarioDao usuarioDao;

	@Inject
	public LoginController(Result result, UsuarioDao usuarioDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
	}
	
	public LoginController() {
		this(null,null);
	}
	
	@Path("/login/formulario")
	public void formulario(){
		
	}
	
	

}
