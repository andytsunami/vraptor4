package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.bean.UsuarioLogado;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {
	
	private final Result result;
	
	private final UsuarioDao usuarioDao;
	
	private final Validator validator;
	
	private final UsuarioLogado usuarioLogado;

	@Inject
	public LoginController(Result result, UsuarioDao usuarioDao,Validator validator,UsuarioLogado usuarioLogado) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.validator = validator;
		this.usuarioLogado = usuarioLogado;
	}
	
	public LoginController() {
		this(null,null,null,null);
	}
	
	@Path("/login/formulario")
	public void formulario(){
		
	}
	
	@Post("/login/autentica")
	public void autentica(Usuario usuario){
		if(!usuarioDao.existe(usuario)){
			validator.add(new I18nMessage("login", "login.invalido"));
			validator.onErrorUsePageOf(this).formulario();
		}
		
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(ProdutoController.class).lista();
		
	}
}