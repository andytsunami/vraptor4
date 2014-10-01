package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.annotation.Transacional;

@Intercepts(after = AutorizadorInterceptor.class)
@AcceptsWithAnnotations(Transacional.class)
public class ControleDeTransacaoInterceptor{

	private final EntityManager em;
	
	@Inject
	public ControleDeTransacaoInterceptor(EntityManager em) {
		this.em = em;
	}
	
	public ControleDeTransacaoInterceptor() {
		this(null);
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		em.getTransaction().begin();
		stack.next();
		em.getTransaction().commit();
	}
}