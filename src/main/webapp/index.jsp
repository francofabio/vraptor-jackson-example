<!DOCTYPE html>
<html>
<head>
	<title>vraptor-jackson-example</title>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h2>vraptor-jackson-example (utilização de Map)</h2>
			</div>
		</div>
		<div class="row">
			<h4>Requisição:</h4>
			<p>GET /vraptor-jackson-example/contatos/</p>
			<h4>Resposta:</h4>
			<pre id="result1">
			</pre>
		</div>
		
		<div class="row">
			<h4>Requisição:</h4>
			<p>GET /vraptor-jackson-example/contatos/1</p>
			<h4>Resposta:</h4>
			<pre id="result2">
			</pre>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
			/*
			 * Enviar um request para o serviço de contatos. 
			 * Será exibido o JSON retornado pelo serviço
			 */
			$.ajax({
				url: "/vraptor-jackson-example/contatos/",
				dataFilter: function (data, type) {
					$("#result1").text(data);
				}
			});
			$.ajax({
				url: "/vraptor-jackson-example/contatos/1",
				dataFilter: function (data, type) {
					$("#result2").text(data);
				}
			});
		});
	</script>
</body>
</html>
