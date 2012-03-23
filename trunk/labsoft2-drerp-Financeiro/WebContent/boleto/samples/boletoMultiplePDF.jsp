<%@ page import="java.util.List" %><%@
	page import="java.util.ArrayList" %><%@
	page import="com.boletobancario.boleto.pdf.BoletoPDFFormatter" %><%@
	page import="com.boletobancario.boleto.BoletoFactory" %><%
	
	
	// Exemplo com multiplos boletos por documento PDF.
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
	
	
	factory.setNomeCedente( "Empresa Demonstraзгo LTDA." );
	factory.setLocalPagamento( "Pagбvel em qualquer agкncia bancбria atй o vencimento." );
	
	factory.setNomeSac( "Beltrano de Tal" );
	factory.setEnderecoSac( "R. Silas Salazar, 768 - 8є Andar" );
	
	factory.setCepSac( "12345678" );
	
	factory.setCidadeSac( "Sгo Paulo" );
	factory.setEstadoSac( "SP" );
	
	factory.setMensagem( 1, "Apуs o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
	
	factory.setCustomContent( "imageC63:cabecalho.png|nl:1|textBC20: |nl:2|textBC14:Exemplo com mъltiplos boletos por documento PDF|nl:2|textBC16:Fatura {parcela}|nl:3|" );

	List boletos = new ArrayList();
	
	factory.setParcela( "01" );
	boletos.add( factory.createBoleto() );
	
	factory.setParcela( "02" );
	boletos.add( factory.createBoleto() );
	
	factory.setParcela( "03" );
	boletos.add( factory.createBoleto() );
	
	response.setContentType( "application/x-pdf" );
	response.setHeader( "Pragma", "public" );
	response.setHeader( "Cache-Control", "max-age=0" );
	response.setHeader( "Content-Disposition", "attachment; filename=\"boleto.pdf\"" );
	
	new BoletoPDFFormatter( boletos, BoletoPDFFormatter.LAYOUT_NORMAL, response.getOutputStream() ).format();
	
%>