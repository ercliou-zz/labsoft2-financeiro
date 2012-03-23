<%@ page import="java.util.List" %><%@ 
    page import="java.util.ArrayList" %><%@ 
    page import="com.boletobancario.boleto.html.BoletoHTMLFormatter" %><%@ 
    page import="com.boletobancario.boleto.BoletoFactory" %><%
    
    
	// Exemplo com multiplos boletos por documento HTML.
	// Existe uma quebra de pagina entre os boletos, somente visivel na visualizacao de impressao.
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
	
	
	factory.setNomeCedente( "Empresa Demonstração LTDA." );
	factory.setLocalPagamento( "Pagável em qualquer agência bancária até o vencimento." );
	
	factory.setNomeSac( "Beltrano de Tal" );
	factory.setEnderecoSac( "R. Silas Salazar, 768 - 8º Andar" );
	
	factory.setCepSac( "12345678" );
	
	factory.setCidadeSac( "São Paulo" );
	factory.setEstadoSac( "SP" );
	
	factory.setMensagem( 1, "Após o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
	
	factory.setCustomContent( "<br /><br /><b>Existe uma quebra de página entre os boletos, somente visível na visualização de impressão</b><br /><br />" +
			"<img src=\"../imagens/logo.png\" alt=\"Boleto Bancário . com\" /><br /><br />" +
			"<b>Esta é sua parcela de número: {parcela}</b><br /><br /><br /><hr />" );
	
	List boletos = new ArrayList();
	
	factory.setParcela( "01" );
	boletos.add( factory.createBoleto() );
	
	factory.setParcela( "02" );
	boletos.add( factory.createBoleto() );
	
	
	factory.setParcela( "03" );
	boletos.add( factory.createBoleto() );
	
	out.print( BoletoHTMLFormatter.asSlimWebPage( boletos ) );
%>