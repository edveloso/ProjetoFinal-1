package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@Table(name="glossario")
@XStreamAlias("glossario")
public class Glossario implements Serializable{

	private static final long serialVersionUID = 1L;
	@XStreamOmitField
	private Long id;
	private String sigla;
	private String definicao;
	
	@Id
	@GeneratedValue
	@Column(name = "glossario_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDefinicao() {
		return definicao;
	}
	public void setDefinicao(String definicao) {
		this.definicao = definicao;
	}
	
}