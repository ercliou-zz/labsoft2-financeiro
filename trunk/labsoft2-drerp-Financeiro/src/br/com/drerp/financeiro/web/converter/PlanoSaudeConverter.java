package br.com.drerp.financeiro.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;

@FacesConverter("planoSaudeConverter")
public class PlanoSaudeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		PlanoSaudeBR planoSaudeBR = new PlanoSaudeBR();
		return planoSaudeBR.getById(Long.parseLong(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
//		return ((PlanoSaude)arg2).getId().toString();
		return ((Long) arg2).toString();
	}
	
	

}
