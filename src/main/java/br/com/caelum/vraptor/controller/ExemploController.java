package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class ExemploController {

	@Inject
	private Result result;

	@Path("/foo")
	public void foo() {
		result.forwardTo(this).bar();
	}

	@Path("/bar")
	public void bar() {
	}
}