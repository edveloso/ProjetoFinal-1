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
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@XStreamAlias("requisitoNaoFuncional")
public class RequisitoNaoFuncional implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	@XStreamOmitField
	private CasoDeUso casoDeUso;
	
	public RequisitoNaoFuncional() {
	}

	@Id
	@GeneratedValue
	@XmlElement(name= "requisito_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name= "requisito_descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = CasoDeUso.class)
	@PrimaryKeyJoinColumn
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
}
