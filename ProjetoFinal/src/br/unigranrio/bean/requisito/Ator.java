package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;



@Entity
@Table(name="ator")
@XStreamAlias("ator")
public class Ator implements Serializable{

	private static final long serialVersionUID = 1L;
	@XStreamOmitField
	private Long id;
	private String nome;
	@XStreamOmitField
	private Projeto projeto;
	@XStreamOmitField
	private List<CasoDeUsoAtor> casosDeUsoAtor;
	private String tipo;

	public Ator() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="ator_id")
	@XmlElement(name="ator_id")
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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pk.ator")
	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean equals(Ator ator) {
		return this.nome.equals(ator.nome) && this.projeto.getId().equals(ator.projeto.getId());
	}

}
