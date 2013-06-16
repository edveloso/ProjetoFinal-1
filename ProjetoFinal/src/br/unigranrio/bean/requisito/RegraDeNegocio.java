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

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@XStreamAlias("regraDeNegocio")
public class RegraDeNegocio implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	private String codigo;
	@XStreamOmitField
	private List<CasoDeUsoRegra> casosDeUsoRegra;
	private Projeto projeto;
	
	public RegraDeNegocio() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Projeto.class)
	@PrimaryKeyJoinColumn
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pk.regra", cascade=CascadeType.REMOVE)
	public List<CasoDeUsoRegra> getCasoDeUsoRegra() {
		return casosDeUsoRegra;
	}

	public void setCasoDeUsoRegra(List<CasoDeUsoRegra> casosDeUsoRegra) {
		this.casosDeUsoRegra = casosDeUsoRegra;
	}

}
