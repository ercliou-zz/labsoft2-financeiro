package br.com.drerp.financeiro.model.transferencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FIN_PAGADOR")
public class Pagador {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String documento;
	private String infoBancaria;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
