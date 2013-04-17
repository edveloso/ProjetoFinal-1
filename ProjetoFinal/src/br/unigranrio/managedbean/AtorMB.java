package br.unigranrio.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Ator;

@ManagedBean
@SessionScoped
public class AtorMB {

	private Ator ator = new Ator();
	private ListDataModel<Ator> atores = new ListDataModel<Ator>();
	
	public String addAtor() {
		return "addAtores";
	}
	
	public String salvar(Ator ator){
		return "listAtores";
	}
	
	public AtorMB() {
		// TODO Auto-generated constructor stub
	}

	public ListDataModel<Ator> getAtores() {
		atores = new ListDataModel<Ator>();
		return atores;
	}

	public void setAtores(ListDataModel<Ator> atores) {
		this.atores = atores;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	
}
