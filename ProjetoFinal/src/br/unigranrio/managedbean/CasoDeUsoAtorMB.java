package br.unigranrio.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;
	
	@ManagedProperty(value="#{atorMB}")
	private AtorMB atorMB;
	
	public CasoDeUsoAtorMB() {
	}
	
	public void listAtores(){
		long id = atorMB.getAtor().getProjeto().getId();
		System.out.println(id);
		listAtores = controlAtor.selecionarTodosProjeto(id);
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
		return listAtores;
	}

	public void setListAtores(List<Ator> listAtores) {
		this.listAtores = listAtores;
	}
	
}
