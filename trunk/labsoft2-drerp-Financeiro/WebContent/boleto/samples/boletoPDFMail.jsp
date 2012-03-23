<%@ page import="com.boletobancario.boleto.Boleto" %><%@
    page import="com.boletobancario.boleto.BoletoFactory" %><%@
    page import="com.boletobancario.boleto.mail.SmartMailSender" %><%@
    page import="com.boletobancario.boleto.pdf.BoletoPDFFormatter" %><%@
    
    page import="java.io.ByteArrayOutputStream" %><%

    
	// Exemplo que envia o boleto por e-mail, para isto eh preciso configurar os dados do servidor
	// de e-mail. Veja explicacoes abaixo.
	BoletoFactory factory = new BoletoFactory();
	
	factory.setBanco( BoletoFactory.BRADESCO );
	// Pode ser passado tambem o numero do banco no lugar da constante. Ex:
	//factory.setBanco( "237" );
	factory.setAgencia( "123" );
	factory.setCedente( "4567" );
	factory.setCarteira( "06" );
	factory.setNossoNumero( "378" );
	factory.setValor( "189,55" );
	factory.setVencimento( "17/03/2012" );
	
	
	factory.setNomeCedente( "Empresa Demonstraзгo LTDA." );
	factory.setLocalPagamento( "Pagбvel em qualquer agкncia bancбria atй o vencimento." );
	
	factory.setNomeSac( "Beltrano de Tal" );
	factory.setEnderecoSac( "R. Silas Salazar, 768 - 8є Andar" );
	
	factory.setCepSac( "12345678" );
	
	factory.setCidadeSac( "Sгo Paulo" );
	factory.setEstadoSac( "SP" );
	
	factory.setMensagem( 1, "Apуs o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
	
	// As cinco linhas de codigo seguintes devem ser comentadas e as posteriores descomentadas
	// e configuradas para o teste de envio por email.
	response.setContentType( "application/x-pdf" );
	response.setHeader( "Pragma", "public" );
	response.setHeader( "Cache-Control", "max-age=0" );
	response.setHeader( "Content-Disposition", "attachment; filename=\"boleto.pdf\"" );
	new BoletoPDFFormatter( factory.createBoleto(), BoletoPDFFormatter.LAYOUT_NORMAL, response.getOutputStream() ).format();
	
	// Para o envio efetivo por email o codigo abaixo deve ser utilizado.
	// Ha necessidade de preencher os dados do servidor de e-mail como endereco, usuario e senha.
	
	//ByteArrayOutputStream bos = new ByteArrayOutputStream();
	Boleto boleto = factory.createBoleto();
	//new BoletoPDFFormatter( boleto, BoletoPDFFormatter.LAYOUT_NORMAL, bos ).format();
	 
	//SmartMailSender mailSender = new SmartMailSender();
	//mailSender.setSmtpHost("smtp.suaempresa.com.br"); // endereco do servidor de e-mail.
	//mailSender.setSmtpUser("usuario.servidor.email"); // usuario no servidor de e-mail.
	//mailSender.setSmtpPassword("senha.usuario"); // senha do usuario no servidor de e-mail.
	//mailSender.setEmailFrom("Sua Empresa <contato@suaempresa.com.br>");
	// //mailSender.setMaxRetries(0); // Verifique a documentacao da classe para mais detalhes.
	// //mailSender.setRetryIntervalInSeconds(3) // Verifique a documentacao da classe para mais detalhes.
	//
	//String to = "cliente@outraempresa.com.br";
	// 
	//String subject = "Boleto de Cobranca - Pedido 554433";
	// 
	//String body = "Prezado(a) {sac.primeiro-nome},\n\n";
	//body += "Segue anexo seu boleto referente a compra realizada.\n";
	//body += "Este boleto deve ser pago ate: {vencimento}.\n";
	//body += "Assim que confirmarmos o pagamento seu produto sera enviado.\n\n";
	//body += "Atenciosamente,\n\n";
	//body += "Sua empresa.";
	
	//mailSender.sendMail( boleto, to, subject, body, SmartMailSender.createAttachment("boleto.pdf", bos.toByteArray() ) );
	//out.print( "E-mail enviado ao endereco: " + to );
%>