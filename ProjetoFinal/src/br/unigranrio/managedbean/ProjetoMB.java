package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.ProjetoDAO;

@ManagedBean
@SessionScoped
public class ProjetoMB {
	
	private Projeto projeto = new Projeto();
	private ListDataModel<Projeto> projetos = new ListDataModel<Projeto>();
	ProjetoDAO dao = new ProjetoDAO();
	
	@SuppressWarnings("unchecked")
	public String salvar(Projeto projeto){
		dao.gravar(projeto);
		projeto = new Projeto();
		return "listProjetos";
	}
	
	public String remover(){
		projeto = projetos.getRowData();
		dao.removerPorId(projeto.getId());
		return "listProjetos";		
	}
	
	public void limpar(){
		
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
