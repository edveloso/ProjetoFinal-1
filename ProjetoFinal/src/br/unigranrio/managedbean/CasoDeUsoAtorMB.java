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

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.CasoDeUsoAtor;
import br.unigranrio.controller.AtorController;
import br.unigranrio.controller.CasoDeUsoAtorController;

@ManagedBean
@SessionScoped
public class CasoDeUsoAtorMB {

	private CasoDeUsoAtor casoAtor = new CasoDeUsoAtor();
	private ListDataModel<CasoDeUsoAtor> listCasoAtor;
	private CasoDeUsoAtorController control = new CasoDeUsoAtorController();
	private AtorController controlAtor = new AtorController();
	private List<Ator> listAtores;
	private List<CasoDeUsoAtor> listAtoresCaso;
	private long atorId;
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	@ManagedProperty(value="#{atorMB}")
	private AtorMB atorMB;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	public CasoDeUsoAtorMB() {
	}
	
	public void escolhe(ActionEvent actionEvent){
		casoAtor = listCasoAtor.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ator Escolhido: " + casoAtor.getAtor().getNome(), null));
	}
	
	public String remover(ActionEvent actionEvent){
		control.removerObj(casoAtor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ator Removido com Sucesso", ""));
		return "updateCasos";
	}

	public List<CasoDeUsoAtor> getlistAtoresCaso(){
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			listAtoresCaso = new ArrayList<CasoDeUsoAtor>();
		} else {
			long id = caso.getId();
			listAtoresCaso = new ArrayList<CasoDeUsoAtor>(control.selecionarTodosPorCaso(id));
		}
		return listAtoresCaso;
	}
	
	public void setListAtoresCaso(List<CasoDeUsoAtor> listAtoresCaso) {
		this.listAtoresCaso = listAtoresCaso;
	}

	public CasoDeUsoAtor getCasoAtor() {
		return casoAtor;
	}

	public void setCasoAtor(CasoDeUsoAtor casoAtor) {
		this.casoAtor = casoAtor;
	}

	public ListDataModel<CasoDeUsoAtor> getListCasoAtor() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			listCasoAtor = new ListDataModel<CasoDeUsoAtor>();
		} else {
			long id = caso.getId();
			listCasoAtor = new ListDataModel<CasoDeUsoAtor>(control.selecionarTodosPorCaso(id));
		}
		return listCasoAtor;
	}

	public void setListCasoAtor(ListDataModel<CasoDeUsoAtor> listCasoAtor) {
		this.listCasoAtor = listCasoAtor;
	}

	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}

	public AtorMB getAtorMB() {
		return atorMB;
	}

	public void setAtorMB(AtorMB atorMB) {
		this.atorMB = atorMB;
	}

	public List<Ator> getListAtores() {
		long id = projetoMB.getProjeto().getId();
		listAtores = controlAtor.selecionarTodosProjeto(id);
		return listAtores;
	}
	
	public void setListAtores(List<Ator> listAtores) {
		this.listAtores = listAtores;
	}

	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}
	
	public String salvar(){
		String erro = null;
		CasoDeUso casoDeUso = new CasoDeUso(); 
		casoDeUso = casoMB.getCasoDeUso();
		Ator ator = new Ator(); 
		ator = controlAtor.selecionaAtorPorId(atorId);
		casoAtor.setCasoDeUso(casoDeUso);
		casoAtor.setAtor(ator);
		erro = control.gravar(casoAtor);
		if(erro == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ator do Caso de Uso Salvo com Sucesso " + casoAtor.getAtor().getNome(), null));
			casoAtor = new CasoDeUsoAtor();
			return "updateCasos";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir Ator do Caso de Uso " + erro, null));
			casoAtor = new CasoDeUsoAtor();
			return "updateCasos";
		}
	}

	public long getAtorId() {
		return atorId;
	}

	public void setAtorId(long atorId) {
		this.atorId = atorId;
	}
	
	public void limpar(){
		casoAtor = new CasoDeUsoAtor();
	}

}
