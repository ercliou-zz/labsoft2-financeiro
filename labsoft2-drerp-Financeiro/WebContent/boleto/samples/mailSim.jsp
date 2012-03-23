<%@ page import="java.io.File" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Boleto Banc�rio . com - Exemplos</title>
		<link rel="shortcut icon" href="http://www.boletobancario.com/favicon.ico" />
		<link href="../css/estilo.css" rel="stylesheet" type="text/css" title="Boleto" />
	</head>
	<body>
		<div id="mestre">
			<div id="cabecalho">
				<a href="http://www.boletobancario.com/"><img src="../imagens/logo.png" alt="Boleto Banc�rio . com" /></a>
				<h1>Boleto Banc�rio . com</h1>
				<h2>Desde 2000 no mercado de emiss�o de boletos!</h2>
			</div>
			<div id="conteudo">
				<ul id="menu_int">
					<li><a href="../index.jsp">In�cio</a></li>
				</ul>
				<p class="item">Esta � apenas uma simula��o. Para testar o recebimento do boleto por e-mail � necess�rio configurar os dados do servidor de e-mail.</p>
				<p class="item">Para configurar os dados do servidor de e-mail edite o arquivo <strong><%= getServletContext().getRealPath("") + System.getProperty( "file.separator" ) + "samples" + System.getProperty( "file.separator" ) + "boletoPDFMail.jsp" %></strong>.</p>
				<p class="item">Prezado cliente sua compra foi finalizada com sucesso.<br />
				Uma mensagem contendo o boleto referente a esta compra foi enviada ao seu endere�o de e-mail.<br />
				Assim que seu pagamento for confirmado o pedido ser� enviado. Obrigado.</p>
				<h3 class="esp"><strong>Simula��o</strong></h3>
				<p class="c"><a href="boletoPDFMail.jsp" class="bt">Enviar Boleto</a></p>
			</div>
			<div id="rodape"><address>Rua Des. Ermelino de Le�o, 35 - 3� Andar - Centro - Curitiba - PR<br /></address></div>
		</div>
	</body>
</html>