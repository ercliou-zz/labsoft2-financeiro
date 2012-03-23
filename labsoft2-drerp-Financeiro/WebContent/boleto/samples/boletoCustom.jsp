<%@ page import="com.boletobancario.boleto.html.BoletoHTMLFormatter" %><%@
    page import="com.boletobancario.boleto.BoletoFactory" %><%

    
	// Exemplo customizado utilizando dados estaticos. Na aplicacao real os
	// dados devem ser atribuidos dinamicamente.
	BoletoFactory factory = new BoletoFactory();
	
	factory.setBanco( BoletoFactory.BRADESCO );
	// Pode ser passado tambem o numero do banco no lugar da constante. Ex:
	//factory.setBanco( "237" );
	factory.setAgencia( "123" );
	factory.setCedente( "4567" );
	factory.setCarteira( "06" );
	factory.setNossoNumero( "525" );
	factory.setValor( "125,80" );
	factory.setVencimento( "17/03/2012" );
	
	
	factory.setNomeCedente( "Empresa Demonstra��o LTDA." );
	factory.setLocalPagamento( "Pag�vel em qualquer ag�ncia banc�ria at� o vencimento." );
	
	factory.setNomeSac( "Beltrano de Tal" );
	factory.setEnderecoSac( "R. Silas Salazar, 768 - 8� Andar" );
	
	factory.setCepSac( "12345678" );
	
	factory.setCidadeSac( "S�o Paulo" );
	factory.setEstadoSac( "SP" );
	
	factory.setMensagem( 1, "Ap�s o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
	
	//Define o conte�do customizado, exibido na parte superior do boleto. O formato � HTML, livre.
	//Deve ser usado com extrema cautela pois erros neste HTML podem descaracterizar o boleto.	
	factory.setCustomContent( "<img src=\"../imagens/logo.png\" alt=\"Boleto Banc�rio . com\" /><br />" +
		"<br /><b>Prezado(a) {sac.primeiro-nome}, Estes s�o os dados da sua compra</b>:<br />" +
		"<ul><li>Produto NONONONO.A - 2 Unidades: R$ 25,80</li>" +
		"<li>Produto NONONONO.B - 7 Unidades: R$ 77,00</li>" +
		"<li>Produto NONONONO.C - 2 Unidades: R$ 33,00</li></ul>" +
		"<b>Total da Fatura: R$ {valor}</b><br /><br /><hr />" );
	
	out.print( BoletoHTMLFormatter.asSlimWebPage( factory.createBoleto() ) );
%>