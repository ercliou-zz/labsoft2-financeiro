package br.com.drerp.financeiro.web.transferencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.BoletoBR;
import br.com.drerp.financeiro.model.transferencia.Fatura;

import com.boletobancario.boleto.html.BoletoHTMLFormatter;

@ManagedBean(name = "boletoBean")
@RequestScoped
public class BoletoBean {
	
	private Fatura fatura;
	
	private BoletoBR boletoBR;
	
	
	public BoletoBean() {
	    boletoBR = new BoletoBR();
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	public String gerarBoleto(){
		return "boleto";
	}
	
	public String getBoleto(){
		return BoletoHTMLFormatter.asSlimWebPage(this.boletoBR.gerarBoleto(fatura));
	}
	
	public String gerarBoletoJsp() throws IOException{
		File boletoFile = new File("boleto111.html");
		OutputStream os = new FileOutputStream(boletoFile);
		os.write(BoletoHTMLFormatter.asSlimWebPage(this.boletoBR.gerarBoleto(fatura)).getBytes());
		os.close();
		return "boleto111.html";
	}
	
	
}
