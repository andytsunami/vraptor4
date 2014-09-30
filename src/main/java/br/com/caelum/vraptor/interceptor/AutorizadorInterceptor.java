package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Publico;
import br.com.caelum.vraptor.bean.UsuarioLogado;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;

@Intercepts
public class AutorizadorInterceptor {

	private final UsuarioLogado usuarioLogado;
	
	private final Result result;
	
	private final ControllerMethod controllerMethod;
	
	public AutorizadorInterceptor() {
		this(null,null,null);
	}

	@Inject
	public AutorizadorInterceptor(Result result, ControllerMethod controllerMethod,UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.controllerMethod = controllerMethod;
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		System.out.println("=================================================\nIntercepta");
		if (usuarioLogado.getUsuario() != null) {
			stack.next();
		} else {
			result.redirectTo(LoginController.class).formulario();
		}
	}
	
	@Accepts
	public boolean accepts(){
		System.out.println("==========================================\nLibera");
		return !controllerMethod.containsAnnotation(Publico.class);
	}
}