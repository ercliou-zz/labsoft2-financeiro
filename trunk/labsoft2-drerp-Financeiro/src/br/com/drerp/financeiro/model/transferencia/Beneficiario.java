package br.com.drerp.financeiro.model.transferencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_BENEFICIARIO")
public class Beneficiario extends GenericModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8378357149201490372L;
	private String nome;
	private String documento;
	private String infoBancaria;
	private TipoBeneficiario tipoBeneficiario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getInfoBancaria() {
		return infoBancaria;
	}
	public void setInfoBancaria(String infoBancaria) {
		this.infoBancaria = infoBancaria;
	}
	public TipoBeneficiario getTipoBeneficiario() {
		return tipoBeneficiario;
	}
	public void setTipoBeneficiario(TipoBeneficiario tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}
	
	
}
