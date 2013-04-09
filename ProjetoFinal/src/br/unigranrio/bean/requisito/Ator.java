package br.unigranrio.bean.requisito;

import java.util.List;

import br.unigranrio.bean.requisito.enums.TipoAtor;

public class Ator {

	private Long id;
	private String nome;
	private Projeto projeto;
	private TipoAtor tipo;
	private List<CasoDeUsoAtor> casosDeUsoAtor;

	public Ator() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public TipoAtor getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtor tipo) {
		this.tipo = tipo;
	}

	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}

}
