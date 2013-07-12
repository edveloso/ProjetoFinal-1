package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.controller.RegraDeNegocioController;

@ManagedBean
@SessionScoped
public class RegraDeNegocioMB {
	
	private RegraDeNegocio regra = new RegraDeNegocio();
	private ListDataModel<RegraDeNegocio> list;
	private RegraDeNegocioController control = new RegraDeNegocioController();
	
	//@ManagedProperty(value="#{casoDeUsoMB}")
	//private CasoDeUsoMB casoMB;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	public RegraDeNegocioMB() {
	}

	public RegraDeNegocio getRegra() {
		return regra;
	}

	public void setRegra(RegraDeNegocio regra) {
		this.regra = regra;
	}

	public ListDataModel<RegraDeNegocio> getList() {
		//CasoDeUso caso = casoMB.getCasoDeUso();
		Projeto projeto = projetoMB.getProjeto();
		if(projeto == null){
			list = new ListDataModel<RegraDeNegocio>();
		} else {
			long id = projeto.getId();
			list = new ListDataModel<RegraDeNegocio>(control.selecionaTodosPorProjeto(id));
		}
		return list;
	}

	public void setList(ListDataModel<RegraDeNegocio> list) {
		this.list = list;
	}
	
	//public CasoDeUsoMB getCasoMB() {
		//return casoMB;
	//}

	//public void setCasoMB(CasoDeUsoMB casoMB) {
		//this.casoMB = casoMB;
	//}
	
	public String salvar(){
		String erro = null;
		//CasoDeUso caso = casoMB.getCasoDeUso();
		Projeto projeto = projetoMB.getProjeto();
		erro = control.gravar(projeto, regra);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Salva com Sucesso" + regra.getDescricao(), null));
		}
		regra = new RegraDeNegocio();
		return "updateCasos";
	}
	
	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}

	public String remover(ActionEvent actionEvent){
		control.remover(regra.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Removida com Sucesso", null));
		return "updateCasos";
	}
	
	public void escolhe(){
		regra = list.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Escolhida: " + regra.getDescricao(), null));
	}
	
	public void limpar() {
		regra = new RegraDeNegocio();
	}
	
	public String atualizar(ActionEvent actionEvent){
		String erro = null;
		erro = control.atualizar(regra);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Atualizada com Sucesso" + regra.getDescricao(), null));
		}
		return "updateCasos";
	}
}
