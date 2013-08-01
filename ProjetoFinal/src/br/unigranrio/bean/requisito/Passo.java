package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@Table(name="passo")
@XStreamAlias("passo")
public class Passo implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@XStreamOmitField
	private Long id;
	private String codigo;
	@XStreamOmitField
	private Fluxo fluxo = new Fluxo();	
	@XStreamAlias("ator")
	private String ator;
	private String acao;
	private String complemento;
	private CasoDeUso pontoDeExtensao;
	
	public Passo(String codigo, String acao, String complemento) {
		this.codigo = codigo;
		this.acao = acao;
		this.complemento = complemento; 
	}
	
	public Passo( ) { }
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	@ManyToOne
	@JoinColumn(name="idFluxo")
	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCasoDeUsoExtensao", insertable=false, updatable=false)
	public CasoDeUso getPontoDeExtensao() {
		return pontoDeExtensao;
	}

	public void setPontoDeExtensao(CasoDeUso pontoDeExtensao) {
		this.pontoDeExtensao = pontoDeExtensao;
	}

	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String toString() {
		return "";
	}
	
	@Transient
	public String getPassoAsString() {
		String passoCompleto = this.getCodigo() + " " + this.getAtor() + " " + this.getAcao() + " " + this.getComplemento(); 
		return passoCompleto;
	}
}
 
