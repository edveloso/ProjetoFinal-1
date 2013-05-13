package br.unigranrio.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.controller.PassoController;

@ManagedBean(name="passoMB")
@SessionScoped
public class PassoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Passo passo = new Passo();
	private ListDataModel<Passo> passos;
	private PassoController control = new PassoController();
	
	@ManagedProperty(value="#{fluxoMB}")
	private FluxoMB fluxoMB;

	public String salvar() {
		Fluxo fluxo = fluxoMB.getFluxo();
		passo.setFluxo(fluxo);
		control.gravar(passo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Salvo com Sucesso", passo.getAcao()));
		passo = new Passo();
		return "updateCasos";
	}
	
	public String atualizar(ActionEvent actionEvent){
		control.atualizar(passo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Atualizado com Sucesso", passo.getAcao()));
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(passo.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Removido com Sucesso", ""));
		return "listAtores";
	}
	
	public void limpar(){
		passo = new Passo();
	}
	
	public void escolhe(ActionEvent actionEvent){
		passo = passos.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Escolhido: ", passo.getCodigo().toString()));
	}

	public PassoMB() {
	}

	public ListDataModel<Passo> getPassos() {
		Fluxo fluxo = fluxoMB.getFluxo();
		if(fluxo.equals(null)){
			passos = new ListDataModel<Passo>();
		} else {
			long id = fluxo.getId();
			passos = new ListDataModel<Passo>(control.selecionarTodosFluxo(id));
		}
		return passos;
	}

	public void setPassos(ListDataModel<Passo> passos) {
		this.passos = passos;
	}

	public Passo getPasso() {
		return passo;
	}

	public void setPasso(Passo fluxo) {
		this.passo = fluxo;
	}

	public FluxoMB getFluxoMB() {
		return fluxoMB;
	}

	public void setFluxoMB(FluxoMB fluxoMB) {
		this.fluxoMB = fluxoMB;
	}

}
