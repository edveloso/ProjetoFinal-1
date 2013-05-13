package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.unigranrio.dao.impl.AtorDAO;

@Entity
@XmlRootElement(name = "passo") //representa o elemento principal, ou a tag principal do XML.
public class Passo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer codigo;
	private Fluxo fluxo = new Fluxo();
	private Ator ator = new Ator();
	private String acao;
	private String complemento;
	private CasoDeUso pontoDeExtensao;

	public Passo() {
	}

	public Passo(int codigo, String acao, String complemento) {
		this.codigo = codigo;
		this.acao = acao;
		this.complemento = complemento;
	}

	@Id
	@GeneratedValue
	@XmlElement(name="passo_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="passo_codigo")
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Fluxo.class)
	@JoinColumn
	@XmlElement(name="passo_fluxo")
	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	/*
	 * public Ator getAtorParaXML() { return atorParaXML; }
	 * 
	 * public void setAtorParaXML(Ator atorParaXML) { this.atorParaXML =
	 * atorParaXML; }
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Ator.class)
	@PrimaryKeyJoinColumn
	@XmlElement(name="passo_ator")
	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	@XmlElement(name="passo_acao")
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	@XmlElement(name="passo_complemento")
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@XmlElement(name="passo_pontoExtensao")
	public CasoDeUso getPontoDeExtensao() {
		return pontoDeExtensao;
	}

	public void setPontoDeExtensao(CasoDeUso pontoDeExtensao) {
		this.pontoDeExtensao = pontoDeExtensao;
	}
	
	public String toString() {
		return "P" + codigo + " - " + new AtorDAO().retornaNomePorId(ator.getId()) + " " + acao + " " + complemento;
	}
	
	@Transient
	public String getPassoAsString() {
		return toString();
	}

}
