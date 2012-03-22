package br.com.drerp.financeiro.model.transferencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.drerp.financeiro.dao.GenericModel;

public class Relatorio extends GenericModel {
	
	private String dateBeginString;
	private Calendar dateBegin;
	private String dateEndString;
	private Calendar dateEnd;
	private StatusRequisicaoTransferencia status;
	private TipoTransferencia tipo;
	private String pagador;
	private String beneficiario;
	private long minValue;
	private long maxValue;
	private List<Transferencia> transferencias = new ArrayList<Transferencia>();
	private int numTransferencias = 0;

	
	public Calendar stringToDate(String dateString){
		Calendar dateCalendar = new Calendar() {

			private static final long serialVersionUID = 1L;

			@Override
			public void roll(int field, boolean up) {}
			
			@Override
			public int getMinimum(int field) {return 0;}
			
			@Override
			public int getMaximum(int field) {return 0;}
			
			@Override
			public int getLeastMaximum(int field) {return 0;}
			
			@Override
			public int getGreatestMinimum(int field) {return 0;}
			
			@Override
			protected void computeTime() {}
			
			@Override
			protected void computeFields() {}
			
			@Override
			public void add(int field, int amount) {}
		};
		String[] campos = dateString.split("/");
		dateCalendar.set(new Integer(campos[2]), new Integer(campos[0]), new Integer(campos[1]), 1, 0, 0);
		return dateCalendar;
	}

	public String getDateBeginString() {
		return dateBeginString;
	}

	public void setDateBeginString(String dateBeginString) {
		this.dateBeginString = dateBeginString;
	}

	public Calendar getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Calendar dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEndString() {
		return dateEndString;
	}

	public void setDateEndString(String dateEndString) {
		this.dateEndString = dateEndString;
	}

	public Calendar getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}

	public StatusRequisicaoTransferencia getStatus() {
		return status;
	}

	public void setStatus(StatusRequisicaoTransferencia status) {
		this.status = status;
	}

	public TipoTransferencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransferencia tipo) {
		this.tipo = tipo;
	}

	public String getPagador() {
		return pagador;
	}

	public void setPagador(String pagador) {
		this.pagador = pagador;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public long getMinValue() {
		return minValue;
	}

	public void setMinValue(long minValue) {
		this.minValue = minValue;
	}

	public long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
		this.numTransferencias = transferencias.size();
	}

	public int getNumTransferencias() {
		return numTransferencias;
	}

	public void setNumTransferencias(int numTransferencias) {
		this.numTransferencias = numTransferencias;
	}

}
