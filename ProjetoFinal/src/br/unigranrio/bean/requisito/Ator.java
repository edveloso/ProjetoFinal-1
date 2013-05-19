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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@XmlRootElement(name = "ator")
public class Ator implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Projeto projeto;
	private List<CasoDeUsoAtor> casosDeUsoAtor;

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
	
	@XmlElement(name = "ator_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Projeto.class)
	@PrimaryKeyJoinColumn
	@XmlElement(name = "ator_projeto")
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pk.ator")
	@XmlElementWrapper(name = "casosDeUso_atores")
	@XmlElement(name="ator_casosDeUso")
	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}

}
