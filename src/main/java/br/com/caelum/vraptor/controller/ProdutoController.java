package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
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
}
