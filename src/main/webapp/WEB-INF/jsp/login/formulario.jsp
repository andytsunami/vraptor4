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
		<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet"/>
		<title>Login</title>
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
			<div class="content">
				<div class="row">
					<div class="login-form">
						<h2>Login</h2>
						<form method="get" id="form">
							<fieldset>
								<div class="clearfix">
									<input type="text" placeholder="Usuario" name="usuario.nome">
								</div>
								<div class="clearfix">
									<input type="password" placeholder="Senha" name="usuario.senha"/>
								</div>
								<button class="btn btn-primary" type="button">Logar</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>