package br.com.drerp.financeiro.business.transferencia;

import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.util.FinanceiroConstants;

import com.boletobancario.boleto.Boleto;
import com.boletobancario.boleto.BoletoFactory;

public class BoletoBR {
	
	public Boleto gerarBoleto(Fatura fatura){
		BoletoFactory factory = new BoletoFactory();
		
		factory.setBanco( BoletoFactory.BRADESCO );
		factory.setAgencia( FinanceiroConstants.AGENCIA_CLINICA_BRADESCO );
		factory.setCedente( FinanceiroConstants.CONTA_CLINICA_BRADESCO );
		factory.setNomeCedente( FinanceiroConstants.NOME_CLINICA );
		factory.setCarteira( FinanceiroConstants.CARTEIRA_CLINICA_BRADESCO );
		// Identificador do boleto (deveria persistir um contador no banco para o numero ser unico)
		factory.setNossoNumero( "1" );
		
		factory.setValor( fatura.getValorBoleto() );
		factory.setVencimento( fatura.getDataBoleto(7) );
		
		factory.setLocalPagamento( "Pagável em qualquer agência bancária até o vencimento." );
		
		factory.setNomeSac( fatura.getPagador().getNome() );
		factory.setEnderecoSac( fatura.getPagador().getEndereco().getRua() );
		factory.setCepSac( fatura.getPagador().getEndereco().getCep() );
		factory.setCidadeSac( fatura.getPagador().getEndereco().getCidade() );
		factory.setEstadoSac( fatura.getPagador().getEndereco().getEstado() );
		
		factory.setMensagem( 1, "Após o vencimento, entre em contato com nossa central de atendimento: [b]0800-00001[/b]." );
		
		return factory.createBoleto();
	}
}
