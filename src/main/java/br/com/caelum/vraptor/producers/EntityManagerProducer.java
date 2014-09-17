package br.com.caelum.vraptor.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.JPAUtil;


public class EntityManagerProducer {
	
	@Produces
	public EntityManager criaEntityManager(){
		return JPAUtil.criaEntityManager();
	}

}