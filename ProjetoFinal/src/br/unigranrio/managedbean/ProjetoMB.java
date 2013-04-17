package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;

@ManagedBean
@SessionScoped
public class ProjetoMB {
	
	private Projeto projeto = new Projeto();
	private ListDataModel<Projeto> projetos = new ListDataModel<Projeto>();
	
	public String addProjeto(){
		return "addProjetos";
	}
	
	public String salvar(Projeto projeto){
		return "listProjetos";
	}
	
	public ProjetoMB() {
		// TODO Auto-generated constructor stub
	}

	public ListDataModel<Projeto> getProjetos() {
		projetos = new ListDataModel<Projeto>();
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
