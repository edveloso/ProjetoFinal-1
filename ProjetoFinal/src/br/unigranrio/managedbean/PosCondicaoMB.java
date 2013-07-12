package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.controller.PosCondicaoController;

@ManagedBean
@SessionScoped
public class PosCondicaoMB {
	
	private PosCondicao pos = new PosCondicao();
	private ListDataModel<PosCondicao> list;
	private PosCondicaoController control = new PosCondicaoController();
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	public PosCondicaoMB() {
	}

	public PosCondicao getPos() {
		return pos;
	}

	public void setPos(PosCondicao pos) {
		this.pos = pos;
	}

	public ListDataModel<PosCondicao> getList() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			list = new ListDataModel<PosCondicao>();
		} else {
			long id = caso.getId();
			list = new ListDataModel<PosCondicao>(control.selecionaTodosPorCasoDeUso(id));
		}
		return list;
	}

	public void setList(ListDataModel<PosCondicao> list) {
		this.list = list;
	}
	
	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}

	public String salvar(){
		String erro = null;
		CasoDeUso caso = casoMB.getCasoDeUso();
		pos.setCasoDeUso(caso);
		erro = control.gravar(pos);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pós-Condição Salva com Sucesso " + pos.getDescricao(), null));
		}
		pos = new PosCondicao();
		return "updateCasos";
	}
	
	public String atualizar(){
		String erro = null;
		CasoDeUso caso = casoMB.getCasoDeUso();
		pos.setCasoDeUso(caso);
		erro = control.atualizar(pos);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pós-Condição Atualizada com Sucesso " + pos.getDescricao(), null));
		}
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(pos.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pós-Condição Removida com Sucesso", ""));
		return "updateCasos";
	}
	
	public void escolhe(){
		pos = list.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pós-Condição Escolhida: " + pos.getDescricao(), null));
	}
}
