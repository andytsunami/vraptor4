<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="pro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<pro:bootstrap/>
		<link href="http://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
		<title>Cadastro de produtos</title>
	</head>
	<body>
		<div class="container">
			<c:if test="${not empty errors}">
				<div class="alert alert-danger">
					<c:forEach var="e" items="${errors}">
						${e.category} - ${e.message} <br />
					</c:forEach>
				</div>
			</c:if>
			<h1 class=".h1">Cadastro de produtos</h1>
			<form action="<c:url value='/produto/adiciona'/>" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">Nome:</label>
					<input type="text" name="produto.nome" value="${produto.nome}" class="form-control">
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Valor:</label>
					<input type="text" name="produto.valor" value="${produto.valor}" class="form-control">
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Quantidade:</label>
					<input type="text" name="produto.quantidade" value="${produto.quantidade}" class="form-control">
				</div><br />
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Adicionar</button>
					</div>
				</div>
			</form>
		</div>
		<div id="footer">
		      <div class="container">
		        <p class="muted credit">
		        	<a href='<c:url value="/produto/lista"/>'>Listagem de produtos</a>
		        </p>
		      </div>
		</div>
	</body>
</html>