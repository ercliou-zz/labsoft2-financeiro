
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

@XmlRootElement(name = "registrarEmpresa", namespace = "http://service.financeiro.drerp.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarEmpresa", namespace = "http://service.financeiro.drerp.com.br/")

public class RegistrarEmpresa {

    @XmlElement(name = "arg0")
    private br.com.drerp.financeiro.model.transferencia.Beneficiario arg0;

    public br.com.drerp.financeiro.model.transferencia.Beneficiario getArg0() {
        return this.arg0;
    }

    public void setArg0(br.com.drerp.financeiro.model.transferencia.Beneficiario newArg0)  {
        this.arg0 = newArg0;
    }

}

