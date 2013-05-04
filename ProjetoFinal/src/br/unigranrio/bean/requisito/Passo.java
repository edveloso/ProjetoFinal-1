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

@Entity
public class Passo implements Serializable {
	
	
	private Long id;
	private Integer codigo;
	private Fluxo fluxo = new Fluxo();	
//	private Ator atorParaXML = new Ator();
	private Ator ator = new Ator();
	private String acao;
	private String complemento;
	private CasoDeUso pontoDeExtensao;
	
	public Passo() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Fluxo.class)
	@JoinColumn
	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}
/*
	public Ator getAtorParaXML() {
		return atorParaXML;
	}

	public void setAtorParaXML(Ator atorParaXML) {
		this.atorParaXML = atorParaXML;
	}
*/
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Ator.class)
	@PrimaryKeyJoinColumn
	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	public CasoDeUso getPontoDeExtensao() {
		return pontoDeExtensao;
	}

	public void setPontoDeExtensao(CasoDeUso pontoDeExtensao) {
		this.pontoDeExtensao = pontoDeExtensao;
	}
	
}
