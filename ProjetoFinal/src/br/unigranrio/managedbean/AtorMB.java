package br.unigranrio.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.DAO;

@ManagedBean
@SessionScoped
public class AtorMB implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Ator ator = new Ator();
	private ListDataModel<Ator> atores = new ListDataModel<Ator>();
	private DAO<Ator> dao = new DAO<Ator>(Ator.class);
	private List<Ator> ato;
	public Boolean cadastro = true;
	
	//Lista de Atores
	public List<Ator> getAto(){
		if(ato==null){
			System.out.println("Carregando Atores.");
			ato = new DAO<Ator>(Ator.class).getAllOrder("nome");
		}
		return ato;
	}
	
	public void addAtor(){
		for(Ator atores : this.getAtores()){
			if(atores.getNome().equalsIgnoreCase(this.getAtor().getNome())){
				this.cadastro = false;
				break;
			}
		}if(this.cadastro == true){
			if(this.ator.getNome().length() >20){
				System.out.println("Nome muito grande");
			}else{
				if(ator.getId() == null){
					System.out.println("Cadastro realizado com sucesso");
					dao.adiciona(ator);
					this.ator = new Ator();
				}else{
					System.out.println("Alteração realizada com sucesso");
					dao.atualiza(ator);
				}
			}
		}else {
			System.out.println("Aotr já Registrado");
		}ato = dao.getAllOrder("Nome");
		this.cadastro = true;
			
		}
	

	
	public String salvar(Ator ator){
		return "listAtores";
	}
	
	public AtorMB() {
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

	public DAO<Ator> getDao() {
		return dao;
	}

	public void setDao(DAO<Ator> dao) {
		this.dao = dao;
	}

	public void setAto(List<Ator> ato) {
		this.ato = ato;
	}
	
}
