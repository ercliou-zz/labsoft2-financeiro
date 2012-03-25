package br.com.drerp.financeiro.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class GenericLog extends GenericModel{
	
	private Long dataMS;
	private LogType tipo;
	
	public GenericLog() {
		this.dataMS = (new Date()).getTime();
	}
	
	@Transient
	public Date getData() {
		return new Date(dataMS);
	}
	public LogType getTipo() {
		return tipo;
	}
	public void setTipo(LogType tipo) {
		this.tipo = tipo;
	}
	public Long getDataMS() {
		return dataMS;
	}
	public void setDataMS(Long dataMS) {
		this.dataMS = dataMS;
	}
	
	
}
