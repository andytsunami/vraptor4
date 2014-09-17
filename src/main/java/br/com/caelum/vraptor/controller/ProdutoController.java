package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {

	private final Result result;
	
	private final ProdutoDao produtoDao;
	
	private final Validator validator;
	
	
	@Inject
	public ProdutoController(Result result, ProdutoDao produtoDao, Validator validator) {
		this.result = result;
		this.produtoDao = produtoDao;
		this.validator = validator;
	}
	
	public ProdutoController() {
		this(null,null,null);
	}

	@Path("/produto/sobre")
	public void sobre() {}

	@Path("/produto/lista")
	public void lista() {
		List<Produto> produtos = produtoDao.lista();
		result.include("produtos", produtos);
	}
	
	@Path("/produto/formulario")
	public void formulario(){};
	
	@Post("/produto/adiciona")
	public void adiciona(Produto produto){
		validator.check(produto.getQuantidade() > 1, new I18nMessage("erro", "produto.quantidade.negativa"));
		
		validator.onErrorUsePageOf(this).formulario();

		produtoDao.adiciona(produto);
		result.include("retorno","adiciona");
		result.redirectTo(this).lista();
 	}
	
	@Path("/produto/remove/{id}")
	public void remove(Long id){
		produtoDao.remove(id);
		
		result.include("retorno","remove").redirectTo(this).lista();
	}
	
	@Path("/produto/lista/xml")
	public void listaXml(){
		List<Produto> produtos = produtoDao.lista();
		result.use(Results.xml()).from(produtos).serialize();
	}
}
