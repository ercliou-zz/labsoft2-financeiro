package br.com.drerp.financeiro.model.transferencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_PAGADOR")
public class Pagador extends GenericModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5284836381046982718L;
	private String nome;
	private String documento;
	private String infoBancaria;

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
}
