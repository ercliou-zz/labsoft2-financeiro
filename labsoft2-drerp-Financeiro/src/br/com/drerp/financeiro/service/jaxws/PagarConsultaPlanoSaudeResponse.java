
package br.com.drerp.financeiro.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.5.2
 * Sun Apr 22 19:24:31 BRT 2012
 * Generated source version: 2.5.2
 */

@XmlRootElement(name = "pagarConsultaPlanoSaudeResponse", namespace = "http://service.financeiro.drerp.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagarConsultaPlanoSaudeResponse", namespace = "http://service.financeiro.drerp.com.br/")

public class PagarConsultaPlanoSaudeResponse {

    @XmlElement(name = "return")
    private java.lang.Boolean _return;

    public java.lang.Boolean getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.Boolean new_return)  {
        this._return = new_return;
    }

}

