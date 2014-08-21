package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {

	@Inject
	private Result result;

	@Path("/produto/sobre")
	public void sobre() {}

	@Path("/produto/lista")
	public void lista() {
		ProdutoDao produtoDao = new ProdutoDao(JPAUtil.criaEntityManager());
		List<Produto> produtos = produtoDao.lista();
		result.include("produtos", produtos);
	}
	
	@Path("/produto/formulario")
	public void formulario(){};
	
	@Post("/produto/adiciona")
	public void adiciona(Produto produto){
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		em.getTransaction().begin();
		produtoDao.adiciona(produto);
		em.getTransaction().commit();
		result.include("retorno","adiciona");
		result.redirectTo(this).lista();
 	}
	
	@Path("/produto/remove/{id}")
	public void remove(Long id){
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		em.getTransaction().begin();
		produtoDao.remove(id);
		em.getTransaction().commit();
		
		result.include("retorno","remove").redirectTo(this).lista();
	}
}
