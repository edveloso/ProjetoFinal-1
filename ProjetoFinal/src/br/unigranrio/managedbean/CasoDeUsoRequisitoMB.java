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
import br.unigranrio.bean.requisito.CasoDeUsoRequisito;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.controller.CasoDeUsoRequisitoController;
import br.unigranrio.controller.RequisitoNaoFuncionalController;

@ManagedBean
@SessionScoped
public class CasoDeUsoRequisitoMB {

	private CasoDeUsoRequisito casoRequisito = new CasoDeUsoRequisito();
	private ListDataModel<CasoDeUsoRequisito> listCasoRequisito;
	private CasoDeUsoRequisitoController control = new CasoDeUsoRequisitoController();
	private RequisitoNaoFuncionalController controlRequisito = new RequisitoNaoFuncionalController();
	private List<RequisitoNaoFuncional> listRequisitos;
	private List<CasoDeUsoRequisito> listRequisitosCaso;
	private long requisitoId;
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	@ManagedProperty(value="#{requisitoMB}")
	private RequisitoNaoFuncionalMB requisitoMB;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	public CasoDeUsoRequisitoMB() {
	}
	
	public void escolhe(ActionEvent actionEvent){
		casoRequisito = listCasoRequisito.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito Escolhido: " + casoRequisito.getRequisito().getCodigo() + " - " + casoRequisito.getRequisito().getDescricao(), null));
	}
	
	public String remover(ActionEvent actionEvent){
		control.removerObj(casoRequisito);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito Removido com Sucesso", ""));
		return "updateCasos";
	}

	public List<CasoDeUsoRequisito> getlistRequisitosCaso(){
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			listRequisitosCaso = new ArrayList<CasoDeUsoRequisito>();
		} else {
			long id = caso.getId();
			listRequisitosCaso = new ArrayList<CasoDeUsoRequisito>(control.selecionarTodosPorCaso(id));
		}
		return listRequisitosCaso;
	}
	
	public void setListRequisitosCaso(List<CasoDeUsoRequisito> listRequisitosCaso) {
		this.listRequisitosCaso = listRequisitosCaso;
	}

	public CasoDeUsoRequisito getCasoRequisito() {
		return casoRequisito;
	}

	public void setCasoRequisito(CasoDeUsoRequisito casoRequisito) {
		this.casoRequisito = casoRequisito;
	}

	public ListDataModel<CasoDeUsoRequisito> getListCasoRequisito() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			listCasoRequisito = new ListDataModel<CasoDeUsoRequisito>();
		} else {
			long id = caso.getId();
			listCasoRequisito = new ListDataModel<CasoDeUsoRequisito>(control.selecionarTodosPorCaso(id));
		}
		return listCasoRequisito;
	}

	public void setListCasoRequisito(ListDataModel<CasoDeUsoRequisito> listCasoRequisito) {
		this.listCasoRequisito = listCasoRequisito;
	}

	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}

	public RequisitoNaoFuncionalMB getRequisitoMB() {
		return requisitoMB;
	}

	public void setRequisitoMB(RequisitoNaoFuncionalMB requisitoMB) {
		this.requisitoMB = requisitoMB;
	}

	public List<RequisitoNaoFuncional> getListRequisitos() {
		long id = projetoMB.getProjeto().getId();
		listRequisitos = controlRequisito.selecionaTodosPorProjeto(id);
		return listRequisitos;
	}
	
	public void setListRequisitos(List<RequisitoNaoFuncional> listRequisitos) {
		this.listRequisitos = listRequisitos;
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
		RequisitoNaoFuncional requisito = new RequisitoNaoFuncional(); 
		requisito = controlRequisito.selecionaRequisitoPorId(requisitoId);
		casoRequisito.setCasoDeUso(casoDeUso);
		casoRequisito.setRequisito(requisito);
		erro = control.gravar(casoRequisito);
		if(erro == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisito não Funcional do Caso de Uso Salvo com Sucesso " + casoRequisito.getRequisito().getCodigo() + " - " + casoRequisito.getRequisito().getDescricao(), null));
			casoRequisito = new CasoDeUsoRequisito();
			return "updateCasos";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir Requisito do Caso de Uso " + erro, null));
			casoRequisito = new CasoDeUsoRequisito();
			return "updateCasos";
		}
	}

	public long getRequisitoId() {
		return requisitoId;
	}

	public void setRequisitoId(long requisitoId) {
		this.requisitoId = requisitoId;
	}

}
