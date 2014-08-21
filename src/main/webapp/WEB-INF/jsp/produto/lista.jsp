<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<pro:bootstrap/>
		<title>Cadastro de produtos</title>
	</head>
	<body>
		<h1 class=".h1">Lista de produtos</h1>
		<c:if test="${adiciona eq 'ok'}">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert">&times;</a>
		    <strong>Sucesso!</strong> Produto adicionado com sucesso!
		</div>
		</c:if>
		<table class="table table-stripped table-bordered table-hover">
			<thead>
				<tr>
					<td>Nome</td>
					<td>Valor</td>
					<td>Quantidade</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="p">
					<tr>
						<td>${p.nome}</td>
						<td>${p.valor}</td>
						<td>${p.quantidade}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td>Nome</td>
					<td>Valor</td>
					<td>Quantidade</td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>