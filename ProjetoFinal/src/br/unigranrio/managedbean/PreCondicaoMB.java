package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.controller.PreCondicaoController;

@ManagedBean
@SessionScoped
public class PreCondicaoMB {
	
	private PreCondicao pre = new PreCondicao();
	private ListDataModel<PreCondicao> list;
	private PreCondicaoController control = new PreCondicaoController();
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	public PreCondicaoMB() {
	}

	public PreCondicao getPre() {
		return pre;
	}

	public void setPre(PreCondicao pre) {
		this.pre = pre;
	}

	public ListDataModel<PreCondicao> getList() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			list = new ListDataModel<PreCondicao>();
		} else {
			long id = caso.getId();
			list = new ListDataModel<PreCondicao>(control.selecionaTodosPorCasoDeUso(id));
		}
		return list;
	}

	public void setList(ListDataModel<PreCondicao> list) {
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
		control.gravar(caso, pre);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pré-Condição Salva com Sucesso " + pre.getDescricao(), null));
		pre = new PreCondicao();
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(pre.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pré-Condição Removida com Sucesso", ""));
		return "updateCasos";
	}
	
	public void escolhe(){
		pre = list.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pré-Condição Escolhida: " + pre.getDescricao(), null));
	}
}
