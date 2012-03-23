<%@ page import="com.boletobancario.boleto.html.BoletoHTMLFormatter" %><%@ 
    page import="com.boletobancario.boleto.BoletoFactory" %><%@ 
    page import="java.lang.reflect.InvocationTargetException"%><%
    
    
	// Exemplo buscando dados do request
	try {
		BoletoFactory factory = new BoletoFactory();
		
		factory.setBanco( BoletoFactory.BRADESCO );
		// Pode ser passado tambem o numero do banco no lugar da constante. Ex:
		//factory.setBanco( "237" );
		factory.setAgencia( "123" );
		factory.setCedente( "4567" );
		factory.setCarteira( "06" );
		factory.setNossoNumero( request.getParameter( "nossoNumero" ) );
		factory.setValor( request.getParameter( "valor" ) );
		factory.setVencimento( request.getParameter( "vencimento" ) );
		
		
		factory.setNomeCedente( "Empresa Demonstração LTDA." );
		factory.setLocalPagamento( "Pagável em qualquer agência bancária até o vencimento." );
		
		factory.setNomeSac( request.getParameter( "nomeSac" ) );
		factory.setEnderecoSac( request.getParameter( "enderecoSac" ) );
		
		factory.setCepSac( request.getParameter( "cepSac" ) );
		
		factory.setCidadeSac( request.getParameter( "cidadeSac" ) );
		factory.setEstadoSac( request.getParameter( "estadoSac" ) );
		
		factory.setNumDoc( request.getParameter( "numDoc" ) );
		
		factory.setMensagem( 1, request.getParameter( "msg1" ) );
		factory.setMensagem( 2, request.getParameter( "msg2" ) );
		factory.setMensagem( 3, request.getParameter( "msg3" ) );
		factory.setMensagem( 4, request.getParameter( "msg4" ) );
		factory.setMensagem( 5, request.getParameter( "msg5" ) );
		factory.setMensagem( 6, request.getParameter( "msg6" ) );
		factory.setMensagem( 7, request.getParameter( "msg7" ) );
		factory.setMensagem( 8, request.getParameter( "msg8" ) );
		factory.setMensagem( 9, request.getParameter( "msg9" ) );
		
		factory.setInfoAdicionais( request.getParameter( "infoAdicionais" ) );
		
		out.print( BoletoHTMLFormatter.asSlimWebPage( factory.createBoleto() ) );
	} catch ( Exception _e ) {
		String msg = _e instanceof InvocationTargetException ? _e.getCause().getMessage() : _e.getMessage();
		%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Boleto Bancário . com - Exemplos</title>
		<link rel="shortcut icon" href="http://www.boletobancario.com/favicon.ico" />
		<link href="../css/estilo.css" rel="stylesheet" type="text/css" title="Boleto" />
	</head>
	<body>
		<div id="mestre">
			<div id="cabecalho">
				<a href="http://www.boletobancario.com/"><img src="../imagens/logo.png" alt="Boleto Bancário . com" /></a>
				<h1>Boleto Bancário . com</h1>
				<h2>Desde 2000 no mercado de emissão de boletos!</h2>
			</div>
			<div id="conteudo">
				<ul id="menu_int">
					<li><a href="./form.html">Voltar</a></li>
				</ul>
				&nbsp;
				<br />
				<br />
				&nbsp;
				<h2>
					<%= msg %>
					<br />
					<br />
					<br />
					<br />
					&nbsp;
				</h2>
			</div>
			<div id="rodape">
				<address>Rua Des. Ermelino de Leão, 35 - 3º Andar - Centro - Curitiba-PR</address>
			</div>
		</div>
	</body>
</html>
		<%
	}
%>