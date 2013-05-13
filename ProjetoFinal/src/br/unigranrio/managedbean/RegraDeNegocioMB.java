package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.controller.RegraDeNegocioController;

@ManagedBean
@SessionScoped
public class RegraDeNegocioMB {
	
	private RegraDeNegocio regra = new RegraDeNegocio();
	private ListDataModel<RegraDeNegocio> list;
	private RegraDeNegocioController control = new RegraDeNegocioController();
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	public RegraDeNegocioMB() {
	}

	public RegraDeNegocio getRegra() {
		return regra;
	}

	public void setRegra(RegraDeNegocio regra) {
		this.regra = regra;
	}

	public ListDataModel<RegraDeNegocio> getList() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			list = new ListDataModel<RegraDeNegocio>();
		} else {
			long id = caso.getId();
			list = new ListDataModel<RegraDeNegocio>(control.selecionaTodosPorCasoDeUso(id));
		}
		return list;
	}

	public void setList(ListDataModel<RegraDeNegocio> list) {
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
		control.gravar(caso, regra);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Salva com Sucesso", regra.getDescricao()));
		regra = new RegraDeNegocio();
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(regra.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Removida com Sucesso", ""));
		return "updateCasos";
	}
	
	public void escolhe(){
		regra = list.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra de Negócio Escolhida: ", regra.getDescricao()));
	}
}
