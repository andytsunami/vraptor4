(function($) {
	$().ready(function() {
		$("#logar").click(function(){
			$("#form").attr("action","/produtos/login/autentica");
			$("#form").submit();
		});
	});

})(jQuery);