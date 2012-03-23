<%@ page import="com.boletobancario.boleto.pdf.BoletoPDFFormatter" %><%@
    page import="com.boletobancario.boleto.BoletoFactory" %><%
    
    
    // Exemplo utilizando dados estaticos. Na aplicaaao real os dados devem ser atribuidos
	// dinamicamente.
	BoletoFactory factory = new BoletoFactory();
	
	factory.setBanco( BoletoFactory.BRADESCO );
	// Pode ser passado tambem o numero do banco no lugar da constante. Ex:
	//factory.setBanco( "237" );
	factory.setAgencia( "123" );
	factory.setCedente( "4567" );
	factory.setCarteira( "06" );
	factory.setNossoNumero( "378" );
	factory.setValor( "54,00" );
	factory.setVencimento( "17/03/2012" );
	
	
	factory.setNomeCedente( "Empresa Demonstraзгo LTDA." );
	factory.setLocalPagamento( "Pagбvel em qualquer agкncia bancбria atй o vencimento." );
	
	factory.setNomeSac( "Beltrano de Tal" );
	factory.setEnderecoSac( "R. Silas Salazar, 768 - 8є Andar" );
	
	factory.setCepSac( "12345678" );
	
	factory.setCidadeSac( "Sгo Paulo" );
	factory.setEstadoSac( "SP" );
	
	factory.setMensagem( 1, "Apуs o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
	
	String custom = "imageC63:cabecalho.png|nl:1|";
			custom += "textBC20: |nl:1|";
			custom += "textBC16:Fatura mensal de serviзos|nl:3|";
			custom += "textBL12:Descritivo dos serviзos|nl:2|";
			custom += "tab:2|textNL11:* Quantidade contratada: 100 - |textBL11: R$ 20,00|nl:1|";
			custom += "tab:2|textNL11:* Quantidade excedente: 150 - |textBL11: R$ 40,00|nl:2|";
			custom += "tab:2|textNL11:* Desconto fidelidade: 14 Meses - |textBL11: 10% - (R$ 6,00)|nl:3|";
			custom += "textNL12:Total desta fatura:|textBL12: R$ {valor}|nl:4|";
			custom += "textNL10:Prezado(a) {sac.primeiro-nome}, verificamos que seu consumo excedeu em mais de 20% o plano contratado.|nl:1|";
			custom += "textNL10:Vocк pode alterar seu plano na бrea restrita de nosso site: |textBL10:www.boletobancario.com|";
			custom += "rect:0.5,10,450,575,0.5|";
			custom += "color:200,10,10|";
			custom += "rect:1,120,557,55,18|";
	
	factory.setCustomContent( custom );
	
	response.setContentType( "application/x-pdf" );
	response.setHeader( "Pragma", "public" );
	response.setHeader( "Cache-Control", "max-age=0" );
	response.setHeader( "Content-Disposition", "attachment; filename=\"boleto.pdf\"" );
	
	new BoletoPDFFormatter( factory.createBoleto(), BoletoPDFFormatter.LAYOUT_NORMAL, response.getOutputStream() ).format();

%>