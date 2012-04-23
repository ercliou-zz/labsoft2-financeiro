package br.com.drerp.financeiro.web.tabela;

import java.util.Comparator;

import br.com.drerp.financeiro.model.tabela.Coluna;

public class ColunaComparator implements Comparator<Coluna>{

	public int compare(Coluna o1, Coluna o2) {
		return o1.getId().compareTo(o2.getId());
	}
	
}
