package br.unigranrio.managedbean;

import java.io.Serializable;
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
import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.controller.AtorController;
import br.unigranrio.controller.CasoDeUsoController;
import br.unigranrio.controller.PassoController;
import br.unigranrio.controller.VerboController;

@ManagedBean(name="passoMB")
@SessionScoped
public class PassoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Passo passo = new Passo();
	private ListDataModel<Passo> passos;
	private PassoController control = new PassoController();
	private CasoDeUsoController casoControl = new CasoDeUsoController();
	private AtorController controlAtor = new AtorController();
	private VerboController controlVerbo = new VerboController();
	private long atorId;
	private long casoId;
	private List<CasoDeUsoAtor> listAtores;
	private List<CasoDeUso> listCasos;
	List<String> verbos = controlVerbo.recuperaVerbos();
	List<String> possibilidades = new ArrayList<String>();
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	@ManagedProperty(value="#{fluxoMB}")
	private FluxoMB fluxoMB;
	
	@ManagedProperty(value="#{casoDeUsoAtorMB}")
	private CasoDeUsoAtorMB casoDeUsoAtorMB;
	
	public List<String> complete(String query){

		for (String string : verbos) {
			if(string.toLowerCase().startsWith(query.toLowerCase())){
				possibilidades.add(string);
			}
		}
		return possibilidades;
	}

	public String salvar() {
		Ator ator = controlAtor.selecionaAtorPorId(atorId);
		CasoDeUso caso = casoControl.selecionarCaso(casoId);
		Fluxo fluxo = fluxoMB.getFluxoEscolhido();
		System.out.println("Fluxo: " + fluxo.getNome());
		passo.setFluxo(fluxo);
		passo.setAtor(ator);
		passo.setPontoDeExtensao(caso);
		control.gravar(passo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Salvo com Sucesso " + passo.getCodigo(), null));
		passo = new Passo();
		return "updateCasos";
	}
	
	public String atualizar(ActionEvent actionEvent){
		control.atualizar(passo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Atualizado com Sucesso " + passo.getAcao(), null));
		return "updateCasos";
	}
	
	public String remover(ActionEvent actionEvent){
		control.remover(passo.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Removido com Sucesso", ""));
		return "listAtores";
	}
	
	public void limpar(){
		passo = new Passo();
	}
	
	public void escolhe(ActionEvent actionEvent){
		passo = passos.getRowData();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo Escolhido: " + passo.getCodigo().toString(), null));
	}

	public PassoMB() {
	}

	public ListDataModel<Passo> getPassos() {
		Fluxo fluxo = fluxoMB.getFluxoEscolhido();
		if(fluxo.equals(null)){
			passos = new ListDataModel<Passo>();
		} else {
			long id = fluxo.getId();
			passos = new ListDataModel<Passo>(control.selecionarTodosFluxo(id));
		}
		return passos;
	}

	public void setPassos(ListDataModel<Passo> passos) {
		this.passos = passos;
	}

	public Passo getPasso() {
		return passo;
	}

	public void setPasso(Passo fluxo) {
		this.passo = fluxo;
	}

	public FluxoMB getFluxoMB() {
		return fluxoMB;
	}

	public void setFluxoMB(FluxoMB fluxoMB) {
		this.fluxoMB = fluxoMB;
	}

	public long getAtorId() {
		return atorId;
	}

	public void setAtorId(long atorId) {
		this.atorId = atorId;
	}

	public List<CasoDeUsoAtor> getListAtores() {
		listAtores = casoDeUsoAtorMB.getlistAtoresCaso();
		return listAtores;
	}

	public void setListAtores(List<CasoDeUsoAtor> listAtores) {
		this.listAtores = listAtores;
	}

	public long getCasoId() {
		return casoId;
	}

	public void setCasoId(long casoId) {
		this.casoId = casoId;
	}

	public List<CasoDeUso> getListCasos() {
		long id = projetoMB.getProjeto().getId();
		listCasos = casoControl.selecionarTodosProjeto(id);
		return listCasos;
	}

	public void setListCasos(List<CasoDeUso> listCasos) {
		this.listCasos = listCasos;
	}

	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}

	public CasoDeUsoAtorMB getCasoDeUsoAtorMB() {
		return casoDeUsoAtorMB;
	}

	public void setCasoDeUsoAtorMB(CasoDeUsoAtorMB casoDeUsoAtorMB) {
		this.casoDeUsoAtorMB = casoDeUsoAtorMB;
	}
	
}
