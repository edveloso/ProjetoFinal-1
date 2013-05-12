package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.controller.CasoDeUsoController;

@ManagedBean(name="casoDeUsoMB")
@SessionScoped
public class CasoDeUsoMB {

	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> casosDeUso;
	private CasoDeUsoController control = new CasoDeUsoController();
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;

	public CasoDeUsoMB() {
		
	}
	
	public String addCaso(){
		return "addCasos";
	}
	
	public String atualizaCaso(){
		return "updateCasos";
	}
	
	public String salvar(){
		Projeto projeto = projetoMB.getProjeto();
		casoDeUso.setProjeto(projeto);
		control.gravar(casoDeUso);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso de Uso Salvo com Sucesso", casoDeUso.getNome()));
		casoDeUso = new CasoDeUso();
		return "addCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(casoDeUso.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso de Uso Removido com Sucesso", ""));
		return "listCasos";
	}
	
	public String atualizar(ActionEvent actionEvent){
		control.atualizar(casoDeUso);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso de Uso Atualizado com Sucesso", casoDeUso.getNome()));
		return "listCasos";
	}
	
	public void escolheCaso(ActionEvent actionEvent){
		casoDeUso = casosDeUso.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso Escolhido: ", casoDeUso.getNome()));
	}

	public ListDataModel<CasoDeUso> getCasosDeUso() {
		Projeto projeto = projetoMB.getProjeto();
		if(projeto == null){
			casosDeUso = new ListDataModel<CasoDeUso>();
		} else {
			long id = projeto.getId();
			casosDeUso = new ListDataModel<CasoDeUso>(control.selecionarTodosProjeto(id));
		}
		return casosDeUso;
	}

	public void setCasosDeUso(ListDataModel<CasoDeUso> casosDeUso) {
		this.casosDeUso = casosDeUso;
	}

	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}
}
