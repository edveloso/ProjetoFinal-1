package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.CasoDeUso;

@ManagedBean
@SessionScoped
public class CasoDeUsoMB {

	private CasoDeUso casoDeUso = new CasoDeUso();
	private ListDataModel<CasoDeUso> casosDeUso = new ListDataModel<CasoDeUso>();

	public CasoDeUsoMB() {
		// TODO Auto-generated constructor stub
	}
	
	public String addCaso(){
		return "addCasos";
	}
	
	public String salvar(CasoDeUso caso){
		return "listCasos";
	}
	
	public String apagar(){
		return "listCasos";
	}

	public ListDataModel<CasoDeUso> getCasosDeUso() {
		casosDeUso = new ListDataModel<CasoDeUso>();
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
	
}
