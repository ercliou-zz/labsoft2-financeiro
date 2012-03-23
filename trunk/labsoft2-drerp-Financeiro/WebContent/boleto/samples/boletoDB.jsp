<%@ page import="com.boletobancario.boleto.html.BoletoHTMLFormatter" %><%@
    page import="com.boletobancario.boleto.BoletoFactory" %><%@
    page import="com.boletobancario.boleto.samples.SimpleDB" %><%@
    page import="java.sql.DriverManager" %><%@ 
    page import="java.sql.Connection" %><%@
    page import="java.sql.Statement" %><%@ 
    page import="java.sql.ResultSet" %><%@ 
    page import="java.util.Date" %><%
    
    
	// Esta pagina eh um exemplo de busca em banco de dados para a montagem do boleto.

	// Cria um banco de dados simples para simular a pre-existencia de um em sua empresa.
	// Numa aplicacao real o banco de dados ja existiria, sendo este passo apenas para o exemplo.
	SimpleDB.create();
	
	// Carrega o Driver para o banco de dados em questao.
	// Para MySQL utilizar ConnectorJ disponнvel em: http://www.mysql.com/products/connector/j/
	// e modificar a linha abaixo para Class.forName( "com.mysql.jdbc.Driver" );
	Class.forName( "org.hsqldb.jdbcDriver" );
	
	// Abre uma conexao com o banco de dados.
	// Parametros: url de conexao (varia de acordo com o banco de dados utilizado), usuario, senha
	// Para MySQL utilizar o formato DriverManager.getConnection( "jdbc:mysql://ip/base", "usuario", "senha" );
	Connection conn = DriverManager.getConnection( "jdbc:hsqldb:.", "sa", "" );
	
	// Executa a busca.
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery( "SELECT VALOR, VENCIMENTO, NOSSO_NUMERO, " +
	 "NOME_SACADO, ENDERECO_SACADO, CEP_SACADO, CIDADE_SACADO, ESTADO_SACADO FROM BOLETOS WHERE ID = 1" );
	
	// Move o cursor para a proxima linha de resultado. No caso, a unica retornada.
	rs.next();
	
	// Preenche as variбveis com os dados retornados pela busca.
	Double valor = new Double( rs.getDouble( "VALOR" ) );
	Date vencimento = rs.getDate( "VENCIMENTO" );
	Long nossoNum = new Long( rs.getLong( "NOSSO_NUMERO" ) );
	String nomeSac = rs.getString( "NOME_SACADO" );
	String enderecoSac = rs.getString( "ENDERECO_SACADO" );
	String cepSac = rs.getString( "CEP_SACADO" );
	String cidadeSac = rs.getString( "CIDADE_SACADO" );
	String estadoSac = rs.getString( "ESTADO_SACADO" );
	
	// Fecha todos os recursos abertos e a conexao com o banco de dados.
	rs.close();
	stmt.close();
	conn.close();
	
	// Inicia a montagem do boleto com os dados recuperados do banco de dados.
	BoletoFactory factory = new BoletoFactory();
	
	factory.setBanco( BoletoFactory.BRADESCO );
	// Pode ser passado tambem o numero do banco no lugar da constante. Ex:
	//factory.setBanco( "237" );
	factory.setAgencia( "123" );
	factory.setCedente( "4567" );
	factory.setCarteira( "06" );
	factory.setNossoNumero( nossoNum );
	factory.setValor( valor );
	factory.setVencimento( vencimento );
	
	
	factory.setNomeCedente( "Empresa Demonstraзгo LTDA." );
	factory.setLocalPagamento( "Pagбvel em qualquer agкncia bancбria atй o vencimento." );
	
	factory.setNomeSac( nomeSac );
	factory.setEnderecoSac( enderecoSac );
	
	factory.setCepSac( cepSac );
	
	factory.setCidadeSac( cidadeSac );
	factory.setEstadoSac( estadoSac );
	
	factory.setMensagem( 1, "Apуs o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
	
	out.print( BoletoHTMLFormatter.asSlimWebPage( factory.createBoleto() ) );
%>