package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import br.unigranrio.bean.requisito.enums.TipoAtor;

@Entity
public class Ator implements Serializable{
	
	private Long id;
	private String nome;
	private Projeto projeto;
	private TipoAtor tipo;
//	private List<CasoDeUsoAtor> casosDeUsoAtor;

	public Ator() {
	}

	@Id
	@GeneratedValue
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

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Projeto.class)
	@PrimaryKeyJoinColumn
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

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.ator")
//	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
//		return casosDeUsoAtor;
//	}

//	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
//		this.casosDeUsoAtor = casosDeUsoAtor;
//	}

}
