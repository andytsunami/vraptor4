<%@ tag language="java" pageEncoding="UTF-8" description="Alerta de mensagens"%>
<%@attribute name="mensagem" required="true"%>
<%@attribute name="classe" required="true"%>
<div class="alert ${classe}">
	<a href="#" class="close" data-dismiss="alert">&times;</a>
	<strong>Sucesso!!</strong> ${mensagem}
</div>