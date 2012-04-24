package br.com.drerp.financeiro.web.transferencia;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.BeneficiarioBR;
import br.com.drerp.financeiro.business.transferencia.ContaPagarBR;
import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.business.transferencia.SalarioBR;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.Departamento;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.Salario;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.model.transferencia.TipoContaPagar;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

@ManagedBean(name = "requisicaoTransferenciaBean")
@RequestScoped
public class RequisicaoTransferenciaBean {
	
	private TipoContaPagar tipoContaPagar;
	private SalarioBR salarioBR;
	private ContaPagarBR contaPagarBR;
	private Transferencia transferencia;
	private List<ContaPagar> contas;
	private List<Salario> salarios;
	private Date dataLimite;
	private Departamento departamento;
	
	private PagadorBR pagadorBR;
	private BeneficiarioBR beneficiarioBR;
	private List<Pagador> pagadores;
	private List<Beneficiario> beneficiarios;
	private Long beneficiarioSelecionado;
	
	public RequisicaoTransferenciaBean() {
		this.salarioBR = new SalarioBR();
		this.contaPagarBR = new ContaPagarBR();
		this.pagadorBR = new PagadorBR();
		this.beneficiarioBR = new BeneficiarioBR();
		this.transferencia = new Transferencia();
	}
	
	public String create(){
		return edit();
	}
	
	public String view(){
		return "view";
	}
	
	public String edit(){
		return "edit";
	}
	
	public String list(){
		this.contas = this.contaPagarBR.listarAbertas();
		this.salarios = this.salarioBR.listarPendentes();
		return "list";
	}
	
	public String save(){
		transferencia.setDataRequisicaoMilis((new Date()).getTime());
		transferencia.setStatus(StatusTransferencia.PENDENTE);
		transferencia.setDataLimiteMilis(this.dataLimite.getTime());
		transferencia.setBeneficiario(this.beneficiarioBR.getById(beneficiarioSelecionado));
		transferencia.setPagador(this.pagadorBR.getClinica());
		transferencia.setDepartamento(this.departamento);
		if(this.tipoContaPagar.equals(TipoContaPagar.CONTA)){
			ContaPagar conta = new ContaPagar(this.transferencia);
			this.contaPagarBR.save(conta);
		} else if(this.tipoContaPagar.equals(TipoContaPagar.SALARIO)){
			// TODO preencher salario
			Salario salario = new Salario(transferencia);
			this.salarioBR.save(salario);
		}
		return list();
	}

	public TipoContaPagar getTipoContaPagar() {
		return tipoContaPagar;
	}

	public void setTipoContaPagar(TipoContaPagar tipoContaPagar) {
		this.tipoContaPagar = tipoContaPagar;
	}

	public List<ContaPagar> getContas() {
		return contas;
	}

	public void setContas(List<ContaPagar> contas) {
		this.contas = contas;
	}

	public List<Salario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<Salario> salarios) {
		this.salarios = salarios;
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public List<Pagador> getPagadores() {
		this.pagadores = pagadorBR.list(); 
		return pagadores;
	}

	public void setPagadores(List<Pagador> pagadores) {
		this.pagadores = pagadores;
	}

	public List<Beneficiario> getBeneficiarios() {
		this.beneficiarios = beneficiarioBR.list();
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public Long getBeneficiarioSelecionado() {
		return beneficiarioSelecionado;
	}

	public void setBeneficiarioSelecionado(Long beneficiarioSelecionado) {
		this.beneficiarioSelecionado = beneficiarioSelecionado;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
