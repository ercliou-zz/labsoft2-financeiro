package br.com.drerp.financeiro.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.drerp.financeiro.model.transferencia.Departamento;

@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return Departamento.valueOf(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return ((Departamento) arg2).toString();
	}
	
	

}
