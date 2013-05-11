package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.AtorDAO;
import br.unigranrio.dao.impl.ProjetoDAO;

@ManagedBean(name="projetoMB")
@SessionScoped
public class ProjetoMB {
	
	private Projeto projeto = new Projeto();
	private ListDataModel<Projeto> projetos;
	ProjetoDAO dao = new ProjetoDAO();
	private Projeto projetoSelecionado = new Projeto();

	public String salvar(){
		dao.gravar(projeto);
		projeto = new Projeto();
		return "listProjetos";
	}
	
	public String atualizar(){
		projeto = projetos.getRowData();
		dao.atualizar(projeto);
		//projeto = new Projeto();
		return "listProjetos";
	}
	
	public String remover(){
		projeto = projetos.getRowData();
		dao.removerPorId(projeto.getId());
		return "listProjetos";
	}
	
	public void limpar(){
		new Projeto();
	}
	
	public void escolheProjeto(Projeto projeto){
		this.projeto = projeto;
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

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}
	
}
