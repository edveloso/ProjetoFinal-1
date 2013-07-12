package br.unigranrio.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.controller.GlossarioController;


@ManagedBean
@SessionScoped
public class GlossarioMB {

	private Glossario glossario = new Glossario();
	private ListDataModel<Glossario> glossarios;
	private GlossarioController control = new GlossarioController();
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	@ManagedProperty("#{mensagemMB}")
	private MensagemMB msgMB;
	
	public GlossarioMB(){
		
	}
	
	public Glossario getGlossario() {
		return glossario;
	}

	public void setGlossario(Glossario glossario) {
		this.glossario = glossario;
	}
	
	public ListDataModel<Glossario> getGlossarios() {
		Projeto projeto = projetoMB.getProjeto();
		if(projeto == null){
			glossarios = new ListDataModel<Glossario>();
		}else {
			long id = projeto.getId();
			glossarios = new ListDataModel<Glossario>(control.selecionaTodosPorProjeto(id));
		}
		return glossarios;
	}
	
	public void setGlossarios(ListDataModel<Glossario> glossarios) {
		this.glossarios = glossarios;
	}
	
	public String salvar() {
		String erro = null;
		Projeto projeto = projetoMB.getProjeto();
		erro = control.gravar(projeto, glossario);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));			
		} else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Salvo com Sucesso " + glossario.getSigla(), null));
		}
		glossario = new Glossario();
		return "listGlossarios";
	}
	
	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}
	
	public String remover(ActionEvent actionEvent) {
		control.remover(glossario.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Removido com Sucesso", null));
		return "listGlossarios";
	}

	public void escolheGlossario(ActionEvent actionEvent){
		glossario = glossarios.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Escolhido: " + glossario.getSigla(), null));
	}

	public void limpar(){
		glossario = new Glossario();
	}
	
	public String atualizar(ActionEvent actionEvent) {
		String erro = null;
		erro = 	control.atualizar(glossario);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Glossario Atualizado com Sucesso " + glossario.getSigla(), null));
		}
		glossario = new Glossario();
		return "listGlossarios";
	}

	public MensagemMB getMsgMB() {
		return msgMB;
	}

	public void setMsgMB(MensagemMB msgMB) {
		this.msgMB = msgMB;
	}

}
