package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.ProjetoDAO;

@SessionScoped
@ManagedBean
public class ProjetoMB {
	
	private Projeto projeto = new Projeto();
	private ListDataModel<Projeto> projetos = new ListDataModel<Projeto>();
	ProjetoDAO dao = new ProjetoDAO();

	public String salvar(){
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
	
	public void escolheProjeto(ActionEvent event){
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter) link.findComponent("idProjAlt");
		Long id = (Long) param.getValue();
		this.projeto = (Projeto) dao.selecionaPorId(id);
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
