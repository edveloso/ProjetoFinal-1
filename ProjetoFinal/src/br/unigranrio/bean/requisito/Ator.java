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
import br.unigranrio.bean.requisito.enums.TipoAtor;



@Entity
@XmlRootElement(name = "ator") //representa o elemento principal, ou a tag principal do XML.
public class Ator implements Serializable{
		
	private Long id;
	private String nome;
	private Projeto projeto;
	private TipoAtor tipo;
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
	
	@XmlElement(name= "ator_tipo")
	public TipoAtor getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtor tipo) {
		this.tipo = tipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.ator")
	@XmlElementWrapper(name = "casosDeUso_atores")
	@XmlElement(name="ator_casosDeUso")
	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}

}
