package br.unigranrio.managedbean;/* Imports list */

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.controller.CasoDeUsoController;
import br.unigranrio.controller.ExportadorFormatos;

@ManagedBean
@SessionScoped
public class ExportacaoMB {

	private CasoDeUsoController casoControl = new CasoDeUsoController();
	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> listCasoDeUso;
	private List<Integer> casosDeUsoSelecionados = new ArrayList<Integer>();
	private String link = null;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;
	
	@ManagedProperty(value="#{casoDeUsoMB}")
	private CasoDeUsoMB casoMB;

	public ExportacaoMB() {
	}

	public CasoDeUso getCasoDeUso() {
		return this.casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso arg0) {
		this.casoDeUso = arg0;
	}

	public List<Integer> getCasosDeUsoSelecionados() {
		return this.casosDeUsoSelecionados;
	}

	public void setCasosDeUsoSelecionados(List<Integer> casosDeUsoSelecionados) {
		this.casosDeUsoSelecionados = casosDeUsoSelecionados;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public String exportar() {
		ExportadorFormatos exportador = new ExportadorFormatos();
		casoDeUso = listCasoDeUso.getRowData();
		Projeto projeto = projetoMB.getProjeto();
		link = exportador.exportar(casoDeUso, projeto);
		casoDeUso = new CasoDeUso();
		return "exportacoes";
	}

	public ListDataModel<CasoDeUso> getListCasoDeUso() {
		Projeto projeto = projetoMB.getProjeto();
		if(projeto == null){
			listCasoDeUso = new ListDataModel<CasoDeUso>();
		} else {
			long id = projeto.getId();
			listCasoDeUso = new ListDataModel<CasoDeUso>(casoControl.selecionarTodosProjeto(id));
		}
		return listCasoDeUso;
	}

	public void setListCasoDeUso(ListDataModel<CasoDeUso> listCasoDeUso) {
		this.listCasoDeUso = listCasoDeUso;
	}

	public ProjetoMB getProjetoMB() {
		return projetoMB;
	}

	public void setProjetoMB(ProjetoMB projetoMB) {
		this.projetoMB = projetoMB;
	}

	public CasoDeUsoMB getCasoMB() {
		return casoMB;
	}

	public void setCasoMB(CasoDeUsoMB casoMB) {
		this.casoMB = casoMB;
	}
	
}