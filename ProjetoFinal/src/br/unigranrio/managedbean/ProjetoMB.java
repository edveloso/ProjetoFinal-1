package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.controller.ProjetoController;
import br.unigranrio.dao.impl.ProjetoDAO;

@ManagedBean(name = "projetoMB")
@SessionScoped
public class ProjetoMB {

	private Projeto projeto = new Projeto();
	private ListDataModel<Projeto> projetos;
	ProjetoDAO dao = new ProjetoDAO();
	private ProjetoController control = new ProjetoController();
	
	@ManagedProperty("#{mensagemMB}")
	private MensagemMB msgMB;

	public String salvar() {
		String erro = null;
		erro = control.gravar(projeto);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Projeto Salvo com Sucesso " + projeto.getNome(), null));
		}
		projeto = new Projeto();
		return "listProjetos";
	}

	public String atualizar(ActionEvent actionEvent) {
		String erro = null;
		erro = control.atualizar(projeto);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Projeto Atualizado com Sucesso " + projeto.getNome(), null));
		}
		projeto = new Projeto();
		return "listProjetos";
	}

	public String remover(ActionEvent actionEvent) {
		control.remover(projeto.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Projeto Removido com Sucesso", null));
		return "listProjetos";
	}
	
	public void escolheProjeto(ActionEvent actionEvent){
		projeto = projetos.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Projeto Escolhido: " + projeto.getNome(), null));
		msgMB.setMensagem("Projeto: " + projeto.getId() + " - " + projeto.getNome());
	}

	public void limpar() {
		projeto = new Projeto();
		msgMB.setMensagem("Escolha um projeto abaixo: ");
	}

	public ProjetoMB() {
	}

	public ListDataModel<Projeto> getProjetos() {
		projetos = new ListDataModel<Projeto>(control.retornaTodos());
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

	public MensagemMB getMsgMB() {
		return msgMB;
	}

	public void setMsgMB(MensagemMB msgMB) {
		this.msgMB = msgMB;
	}

}
