package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@XStreamAlias("preCondicao")
public class PreCondicao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;	 
	private CasoDeUso casoDeUso;
	
	public PreCondicao() {
	}

	@Id
	@GeneratedValue
	@XmlElement(name="pre_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="pre_descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = CasoDeUso.class)
	@PrimaryKeyJoinColumn
	@XmlElement(name="pre_casoDeUso")
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
}
