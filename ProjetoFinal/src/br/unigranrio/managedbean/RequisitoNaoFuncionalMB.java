package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.controller.RequisitoNaoFuncionalController;

@ManagedBean
@SessionScoped
public class RequisitoNaoFuncionalMB {
	
	private RequisitoNaoFuncional req = new RequisitoNaoFuncional();
	private ListDataModel<RequisitoNaoFuncional> list;
	private RequisitoNaoFuncionalController control = new RequisitoNaoFuncionalController();
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	public RequisitoNaoFuncionalMB() {
	}

	public RequisitoNaoFuncional getReq() {
		return req;
	}

	public void setReq(RequisitoNaoFuncional req) {
		this.req = req;
	}

	public ListDataModel<RequisitoNaoFuncional> getList() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			list = new ListDataModel<RequisitoNaoFuncional>();
		} else {
			long id = caso.getId();
			list = new ListDataModel<RequisitoNaoFuncional>(control.selecionaTodosPorCasoDeUso(id));
		}
		return list;
	}

	public void setList(ListDataModel<RequisitoNaoFuncional> list) {
		this.list = list;
	}
	
	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}

	public String salvar(){
		CasoDeUso caso = casoMB.getCasoDeUso();
		control.gravar(caso, req);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito Não Funcional Salvo com Sucesso", req.getDescricao()));
		req = new RequisitoNaoFuncional();
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(req.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito Não Funcional Removido com Sucesso", ""));
		return "updateCasos";
	}
	
	public void escolhe(){
		req = list.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito Não Funcional Escolhido: ", req.getDescricao()));
	}
}
