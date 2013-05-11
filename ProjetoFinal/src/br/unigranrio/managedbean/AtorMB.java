package br.unigranrio.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.impl.AtorDAO;

@ManagedBean
@SessionScoped
public class AtorMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ator ator = new Ator();
	private ListDataModel<Ator> atores = new ListDataModel<Ator>();
	private AtorDAO dao = new AtorDAO();
	public Boolean cadastro = true;
	
	@ManagedProperty(value="#{projetoMB}")
	private ProjetoMB projetoMB;

	public void addAtor() {
		for (Ator atores : this.getAtores()) {
			if (atores.getNome().equalsIgnoreCase(this.getAtor().getNome())) {
				this.cadastro = false;
				break;
			}
		}
		if (this.cadastro == true) {
			if (this.ator.getNome().length() > 20) {
				System.out.println("Nome muito grande");
			} else {
				if (ator.getId() == null) {
					System.out.println("Cadastro realizado com sucesso");
					dao.gravar(ator);
					this.ator = new Ator();
				} else {
					System.out.println("Alteração realizada com sucesso");
					dao.atualizar(ator);
				}
			}
		} else {
			System.out.println("Ator já Registrado");
		}
		this.cadastro = true;
	}

	public String salvar() {
		Projeto projeto = projetoMB.getProjetoSelecionado();
		ator.setProjeto(projeto);
		dao.gravar(ator);
		ator = new Ator();
		return "listAtores";
	}

	public AtorMB() {
	}

	public ListDataModel<Ator> getAtores() {
		Projeto projeto = projetoMB.getProjetoSelecionado();
		System.out.println(projeto.getNome());
		if(projeto.equals(null)){
			dao.novoAtorSistema(projeto.getId());
			atores = new ListDataModel<Ator>();
		} else {
			long id = projeto.getId();
			atores = new ListDataModel<Ator>(dao.retornaPorProjeto(id));
		}
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

	public void setProjetoMB(ProjetoMB projetoMB){
		this.projetoMB = projetoMB;
	}
	
	public ProjetoMB getProjetoMB(){
		return projetoMB;
	}

}
