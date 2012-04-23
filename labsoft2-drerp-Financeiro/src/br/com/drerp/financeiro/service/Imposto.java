package br.com.drerp.financeiro.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Imposto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6800135772840118964L;
	private String nome;
	private int codigo;
	private Double aliquota;

	public Imposto() {
	}

	public Imposto(String nome, Double aliquota) {
		this.nome = nome;
		this.aliquota = aliquota;
		setCodigo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		setCodigo();
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo() {
		if (nome == "INSS") {
			codigo = 973;
		} else if (nome == "IRRF") {
			codigo = 987;
		}
	}
	
	public static List<Imposto> aplicaImpostos(Double salarioBruto) {
		List<Imposto> impostos = new ArrayList<Imposto>();
		
		if (salarioBruto <= 868.29) {
			impostos.add(new Imposto("INSS", 7.65));
		} else if (salarioBruto <= 1140) {
			impostos.add(new Imposto("INSS", 8.65));
		} else if (salarioBruto <= 1447) {
			impostos.add(new Imposto("INSS", 9.0));
		} else {
			impostos.add(new Imposto("INSS", 11.0));
		}
		
		if (salarioBruto <= 1313.69) {
			impostos.add(new Imposto("IRRF", 0.0));
		} else if (salarioBruto <= 2625.12) {
			impostos.add(new Imposto("IRRF", 15.0));
		} else {
			impostos.add(new Imposto("IRRF", 27.5));
		}
		
		return impostos;
	}

}
