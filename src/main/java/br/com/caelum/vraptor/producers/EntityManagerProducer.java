package br.com.caelum.vraptor.producers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.JPAUtil;

public class EntityManagerProducer implements Serializable {
	
	private static final long serialVersionUID = 7060715741270746081L;

	@RequestScoped
	@Produces
	public EntityManager criaEntityManager(){
		return JPAUtil.criaEntityManager();
	}

}