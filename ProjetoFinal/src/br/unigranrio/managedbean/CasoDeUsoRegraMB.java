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
import br.unigranrio.bean.requisito.CasoDeUsoRegra;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.controller.CasoDeUsoRegraController;
import br.unigranrio.controller.RegraDeNegocioController;

@ManagedBean
@SessionScoped
public class CasoDeUsoRegraMB {

	private CasoDeUsoRegra casoRegra = new CasoDeUsoRegra();
	private ListDataModel<CasoDeUsoRegra> listCasoRegra;
	private CasoDeUsoRegraController control = new CasoDeUsoRegraController();
	private RegraDeNegocioController controlRegra = new RegraDeNegocioController();
	private List<RegraDeNegocio> listRegras;
	private List<CasoDeUsoRegra> listRegrasCaso;
	private long regraId;
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	@ManagedProperty(value="#{regraMB}")
	private RegraDeNegocioMB regraMB;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	public CasoDeUsoRegraMB() {
	}
	
	public void escolhe(ActionEvent actionEvent){
		casoRegra = listCasoRegra.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra Escolhida: " + casoRegra.getRegra().getCodigo() + " - " + casoRegra.getRegra().getDescricao(), null));
	}
	
	public String remover(ActionEvent actionEvent){
		control.removerObj(casoRegra);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra Removida com Sucesso", ""));
		return "updateCasos";
	}

	public List<CasoDeUsoRegra> getlistRegrasCaso(){
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			listRegrasCaso = new ArrayList<CasoDeUsoRegra>();
		} else {
			long id = caso.getId();
			listRegrasCaso = new ArrayList<CasoDeUsoRegra>(control.selecionarTodosPorCaso(id));
		}
		return listRegrasCaso;
	}
	
	public void setListRegrasCaso(List<CasoDeUsoRegra> listRegrasCaso) {
		this.listRegrasCaso = listRegrasCaso;
	}

	public CasoDeUsoRegra getCasoRegra() {
		return casoRegra;
	}

	public void setCasoRegra(CasoDeUsoRegra casoRegra) {
		this.casoRegra = casoRegra;
	}

	public ListDataModel<CasoDeUsoRegra> getListCasoRegra() {
		CasoDeUso caso = casoMB.getCasoDeUso();
		if(caso == null){
			listCasoRegra = new ListDataModel<CasoDeUsoRegra>();
		} else {
			long id = caso.getId();
			listCasoRegra = new ListDataModel<CasoDeUsoRegra>(control.selecionarTodosPorCaso(id));
		}
		return listCasoRegra;
	}

	public void setListCasoRegra(ListDataModel<CasoDeUsoRegra> listCasoRegra) {
		this.listCasoRegra = listCasoRegra;
	}

	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}

	public RegraDeNegocioMB getRegraMB() {
		return regraMB;
	}

	public void setRegraMB(RegraDeNegocioMB regraMB) {
		this.regraMB = regraMB;
	}

	public List<RegraDeNegocio> getListRegras() {
		long id = projetoMB.getProjeto().getId();
		listRegras = controlRegra.selecionaTodosPorProjeto(id);
		return listRegras;
	}
	
	public void setListRegras(List<RegraDeNegocio> listRegras) {
		this.listRegras = listRegras;
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
		RegraDeNegocio regra = new RegraDeNegocio(); 
		regra = controlRegra.selecionaRegraPorId(regraId);
		casoRegra.setCasoDeUso(casoDeUso);
		casoRegra.setRegra(regra);
		erro = control.gravar(casoRegra);
		if(erro == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Regra do Caso de Uso Salvo com Sucesso " + casoRegra.getRegra().getCodigo() + " - " + casoRegra.getRegra().getCodigo(), null));
			casoRegra = new CasoDeUsoRegra();
			return "updateCasos";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir Regra do Caso de Uso " + erro, null));
			casoRegra = new CasoDeUsoRegra();
			return "updateCasos";
		}
	}

	public long getRegraId() {
		return regraId;
	}

	public void setRegraId(long regraId) {
		this.regraId = regraId;
	}

}
