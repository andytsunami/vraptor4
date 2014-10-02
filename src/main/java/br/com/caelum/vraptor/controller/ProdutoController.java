package br.com.caelum.vraptor.controller;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.mail.HtmlEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Transacional;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {

	private final Result result;
	
	private final ProdutoDao produtoDao;
	
	private final Validator validator;
	
	private final Mailer mailer;
	
	
	@Inject
	public ProdutoController(Result result, ProdutoDao produtoDao, Validator validator,Mailer mailer) {
		this.result = result;
		this.produtoDao = produtoDao;
		this.validator = validator;
		this.mailer = mailer;
	}
	
	public ProdutoController() {
		this(null,null,null,null);
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
	@Transacional
	public void adiciona(@Valid Produto produto){
		validator.onErrorUsePageOf(this).formulario();
		produtoDao.adiciona(produto);
		result.include("retorno","adiciona");
		result.redirectTo(this).lista();
 	}
	
	
	@Transacional
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
	
	@Get("/produto/pedir/{idProduto}")
	public void enviaPedidoDeNovosItens(Long idProduto) throws Exception{
		Produto produto = produtoDao.busca(idProduto);
		HtmlEmail email = new HtmlEmail();
		email.setSubject("[vraptor-produtos] Precisamos de mais bacon" + produto.getId());
		email.addTo("andytsunami@gmail.com");
		String corpo = new Scanner(new File("/home/vasconcelos/workspace/vraptor4/corpoEmail.html")).useDelimiter("\\Z").next();
		
		email.setHtmlMsg(corpo);
		mailer.send(email);
		result.redirectTo(this).lista();
		
	}
}
