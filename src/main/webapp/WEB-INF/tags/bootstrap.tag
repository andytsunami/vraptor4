<%@tag description="Importa estilos e Js do Twitter Bootstrap" pageEncoding="UTF-8" %>
<link rel="stylesheet" type="text/css" href="/vraptor-produtos/resources/bootstrap/css/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="/vraptor-produtos/resources/bootstrap/css/bootstrap.min.css"/>
		<script type="text/javascript" src="/vraptor-produtos/resources/bootstrap/js/jquery-2.1.1.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="/vraptor-produtos/resources/bootstrap/js/bootstrap.min.js" charset="utf-8"></script>
		<style type="text/css" >
			.alert-success {
				color: #468847;
				background-color: #dff0d8;
				border-color: #d6e9c6;
			}
			.alert {
				padding: 8px 35px 8px 14px;
				margin-bottom: 18px;
				color: #c09853;
				text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
				background-color: #fcf8e3;
				border: 1px solid #fbeed5;
				-webkit-border-radius: 4px;
				-moz-border-radius: 4px;
				border-radius: 4px;
			}
			.alert-heading {
				color: inherit;
			}
	
			.alert .close {
				position: relative;
				top: -2px;
				right: -21px;
				line-height: 18px;
			}
			</style>
			<script type="text/javascript" charset="utf-8">
				$(".close").click(function(){
					$(".alert").hide("slow");
				});
			</script>