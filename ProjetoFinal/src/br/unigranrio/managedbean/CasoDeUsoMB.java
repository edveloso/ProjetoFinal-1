package br.unigranrio.managedbean;

import java.util.ArrayList;
import java.util.List;

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
import br.unigranrio.controller.VerboController;

@ManagedBean(name="casoDeUsoMB")
@SessionScoped
public class CasoDeUsoMB {

	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> casosDeUso;
	private CasoDeUsoController control = new CasoDeUsoController();
	
	private VerboController controlVerbo = new VerboController();
	List<String> verbos = controlVerbo.recuperaVerbos();
	List<String> possibilidades = new ArrayList<String>();
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	@ManagedProperty("#{mensagemMB}")
	private MensagemMB msgMB;

	public CasoDeUsoMB() {
		
	}
	
	public List<String> complete(String query){

		for (String string : verbos) {
			if(string.toLowerCase().startsWith(query.toLowerCase())){
				possibilidades.add(string);
			}
		}
		return possibilidades;
	}
	
	public void novoCaso(){
		this.casoDeUso = new CasoDeUso();
	}
	
	public String addCaso(){
		return "addCasos";
	}
	
	public String atualizaCaso(){
		casoDeUso = casosDeUso.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso Escolhido: " + casoDeUso.getNome(), null));
		msgMB.setMensagem("Projeto: " + projetoMB.getProjeto().getId() + " - " + projetoMB.getProjeto().getNome() + " >> Caso de Uso: " + casoDeUso.getCodigo() + " - " + casoDeUso.getNome());
		return "updateCasos";
	}
	
	public String salvar(){
		String erro = null;
		Projeto projeto = projetoMB.getProjeto();
		casoDeUso.setProjeto(projeto);
		erro = control.gravar(casoDeUso);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso de Uso Salvo com Sucesso " + casoDeUso.getNome(), null));
		}
		casoDeUso = new CasoDeUso();
		return "addCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(casoDeUso.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso de Uso Removido com Sucesso", ""));
		return "listCasos";
	}
	
	public String atualizar(ActionEvent actionEvent){
		String erro = null;
		erro = control.atualizar(casoDeUso);
		if(erro != null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso de Uso Atualizado com Sucesso " + casoDeUso.getNome(), null));
		}
		return "listCasos";
	}
	
	public void escolheCaso(ActionEvent actionEvent){
		casoDeUso = casosDeUso.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Caso Escolhido: " + casoDeUso.getNome(), null));
		msgMB.setMensagem("Projeto: " + projetoMB.getProjeto().getId() + " - " + projetoMB.getProjeto().getNome() + " >> Caso de Uso: " + casoDeUso.getCodigo() + " - " + casoDeUso.getNome());
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

	public MensagemMB getMsgMB() {
		return msgMB;
	}

	public void setMsgMB(MensagemMB msgMB) {
		this.msgMB = msgMB;
	}
	
}
