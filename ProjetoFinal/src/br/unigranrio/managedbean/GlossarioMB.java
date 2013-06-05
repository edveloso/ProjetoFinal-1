package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.controller.GlossarioController;


@ManagedBean(name = "glossarioMB")
@SessionScoped
public class GlossarioMB {

	private Glossario glossario = new Glossario();
	private ListDataModel<Glossario> glossarios;
	private GlossarioController control = new GlossarioController();
	
	public String salvar() {
		control.gravar(glossario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Salvo com Sucesso", glossario.getDefinicao()));  
		return "listGlossarios";
	}

	public String atualizar(ActionEvent actionEvent) {
		control.atualizar(glossario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Atualizado com Sucesso", glossario.getDefinicao()));
		return "listGlossarios";
	}

	public String remover(ActionEvent actionEvent) {
		control.remover(glossario.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Removido com Sucesso", ""));
		return "listGlossarios";
	}
	
	public void escolheGlossario(ActionEvent actionEvent){
		glossario = glossarios.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Escolhido: ", glossario.getDefinicao()));
	}

	public void limpar(){
		glossario = new Glossario();
	}

	public GlossarioMB() {
	}

	public ListDataModel<Glossario> getGlossarios() {
		glossarios = new ListDataModel<Glossario>(control.retornaTodos());
		return glossarios;
	}

	public void setGlossarios(ListDataModel<Glossario> glossarios) {
		this.glossarios = glossarios;
	}

	public Glossario getGlossario() {
		return glossario;
	}

	public void setGlossario(Glossario glossario) {
		this.glossario = glossario;
	}

}
