package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import antlr.debug.Event;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.controller.ProjetoController;
import br.unigranrio.dao.impl.AtorDAO;
import br.unigranrio.dao.impl.ProjetoDAO;

@ManagedBean(name = "projetoMB")
@SessionScoped
public class ProjetoMB {

	private Projeto projeto = new Projeto();
	private ListDataModel<Projeto> projetos;
	ProjetoDAO dao = new ProjetoDAO();
	private ProjetoController control = new ProjetoController();

	public String salvar() {
		control.gravar(projeto);
		projeto = new Projeto();
		return "listProjetos";
	}

	public String atualizar(ActionEvent actionEvent) {
		control.atualizar(projeto);
		return "listProjetos";
	}

	public String remover() {
		projeto = projetos.getRowData();
		control.remover(projeto.getId());
		return "listProjetos";
	}
	
	public void escolheProjeto(ActionEvent actionEvent){
		projeto = projetos.getRowData();
	}

	public void limpar() {
		new Projeto();
	}

	public ProjetoMB() {
	}

	public ListDataModel<Projeto> getProjetos() {
		projetos = new ListDataModel<Projeto>(dao.retornarTodos());
		return projetos;
	}

	public void setProjetos(ListDataModel<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
