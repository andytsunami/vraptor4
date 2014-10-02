<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<pro:bootstrap/>
		<link href="http://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
		<title>Cadastro de produtos do ${logado.usuario.nome}</title>
	</head>
	<body>
		<div class="container">
			<h1 class=".h1">Lista de produtos do ${logado.usuario.nome}</h1>
		</div>
		<c:if test="${retorno eq 'adiciona'}">
			<pro:alerta mensagem="Produto adicionado com sucesso!" classe="alert-success"/>
		</c:if>
		<c:if test="${retorno eq 'remove'}">
			<pro:alerta mensagem="Produto removido com sucesso!" classe="alert-warning"/>
		</c:if>
		<table class="table table-stripped table-bordered table-hover">
			<thead>
				<tr>
					<td>ID</td>
					<td>Nome</td>
					<td>Valor</td>
					<td>Quantidade</td>
					<td>Remover</td>
					<td>Pedir mais itens!</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.nome}</td>
						<td>${p.valor}</td>
						<td>${p.quantidade}</td>
						<td><a href="<c:url value='/produto/remove/${p.id}'/>">Remover</a></td>
						<td><a href="<c:url value='/produto/pedir/${p.id}'/>">Pedir mais itens!</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td>ID</td>
					<td>Nome</td>
					<td>Valor</td>
					<td>Quantidade</td>
					<td>Remover</td>
					<td>Pedir mais itens!</td>
				</tr>
			</tfoot>
		</table>
		<div id="footer">
		      <div class="container">
		        <p class="muted credit">
		        	<a href='<c:url value="/produto/formulario"/>'>Adicionar produto</a>
		        </p>
		      </div>
		</div>
	</body>
</html>