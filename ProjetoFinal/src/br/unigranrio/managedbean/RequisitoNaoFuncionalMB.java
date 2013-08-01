package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.controller.RequisitoNaoFuncionalController;

@ManagedBean
@SessionScoped
public class RequisitoNaoFuncionalMB {
	
	private RequisitoNaoFuncional req = new RequisitoNaoFuncional();
	private ListDataModel<RequisitoNaoFuncional> list;
	private RequisitoNaoFuncionalController control = new RequisitoNaoFuncionalController();
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	public RequisitoNaoFuncionalMB() {
	}

	public RequisitoNaoFuncional getReq() {
		return req;
	}

	public void setReq(RequisitoNaoFuncional req) {
		this.req = req;
	}

	public ListDataModel<RequisitoNaoFuncional> getList() {
		Projeto projeto = projetoMB.getProjeto();
		if(projeto == null){
			list = new ListDataModel<RequisitoNaoFuncional>();
		} else {
			long id = projeto.getId();
			list = new ListDataModel<RequisitoNaoFuncional>(control.selecionaTodosPorProjeto(id));
		}
		return list;
	}

	public void setList(ListDataModel<RequisitoNaoFuncional> list) {
		this.list = list;
	}

	public String salvar(){
		String erro = null;
		Projeto projeto = projetoMB.getProjeto();
		erro = control.gravar(projeto, req);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito não Funcional Salvo com Sucesso " + req.getDescricao(), null));
		}
		req = new RequisitoNaoFuncional();
		return "updateCasos";
	}
	
	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(req.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito não Funcional Removido com Sucesso", ""));
		return "updateCasos";
	}
	
	public void escolhe(){
		req = list.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito não Funcional Escolhido: " + req.getDescricao(), null));
	}
	
	public void limpar() {
		req = new RequisitoNaoFuncional();
	}
	
	public String atualizar(ActionEvent actionEvent){
		String erro = null;
		erro = 	control.atualizar(req);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito não Funcional Atualizado com Sucesso " + req.getDescricao(), null));
		}
		return "updateCasos";
	}
	
}
