<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/vraptor-produtos/resources/bootstrap/css/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="/vraptor-produtos/resources/bootstrap/css/bootstrap.min.css"/>
		<title>Lista de produtos</title>
	</head>
	<body>
		<div class="container">
			<h1 class=".h1">Cadastro de produtos</h1>
			<form action="<c:url value='/produto/adiciona'/>" method="post">
				<div>
					<label>Nome:</label>
					<input type="text" name="produto.nome" value="${produto.nome}" class="form-control">
				</div>
				<div>
					<label>Valor:</label>
					<input type="text" name="produto.valor" value="${produto.valor}" class="form-control">
				</div>
				<div>
					<label>Quantidade:</label>
					<input type="text" name="produto.quantidade" value="${produto.quantidade}" class="form-control">
				</div><br />
				<div>
					<button type="submit" class="btn btn-primary">Adicionar</button>
				</div>
			</form>
		</div>
	</body>
</html>