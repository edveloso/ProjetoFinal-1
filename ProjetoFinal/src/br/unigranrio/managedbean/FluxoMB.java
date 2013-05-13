package br.unigranrio.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.controller.FluxoController;

@ManagedBean(name="fluxoMB")
@SessionScoped
public class FluxoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fluxo fluxo = new Fluxo();
	private ListDataModel<Fluxo> fluxos;
	private FluxoController control = new FluxoController();
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;

	public String salvar() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		fluxo.setCasoDeUso(caso);
		control.gravar(fluxo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fluxo Salvo com Sucesso", fluxo.getNome()));
		fluxo = new Fluxo();
		return "updateCasos";
	}
	
	public String atualizar(ActionEvent actionEvent){
		control.atualizar(fluxo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fluxo Atualizado com Sucesso", fluxo.getNome()));
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(fluxo.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fluxo Removido com Sucesso", ""));
		return "listAtores";
	}
	
	public void limpar(){
		fluxo = new Fluxo();
	}
	
	public void escolhe(ActionEvent actionEvent){
		fluxo = fluxos.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fluxo Escolhido: ", fluxo.getTipo()));
	}

	public FluxoMB() {
	}

	public ListDataModel<Fluxo> getFluxos() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso.equals(null)){
			fluxos = new ListDataModel<Fluxo>();
		} else {
			long id = caso.getId();
			fluxos = new ListDataModel<Fluxo>(control.selecionarTodosCaso(id));
		}
		return fluxos;
	}

	public void setFluxos(ListDataModel<Fluxo> fluxos) {
		this.fluxos = fluxos;
	}

	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}

}
