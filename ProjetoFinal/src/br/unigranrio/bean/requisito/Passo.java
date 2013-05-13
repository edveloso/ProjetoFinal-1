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

@Entity
public class Passo implements Serializable { 

	private Long id;
	private Integer codigo;
	private Fluxo fluxo = new Fluxo();	
	private Ator atorParaXML = new Ator();
	private Ator ator = new Ator();
	private String acao;
	private String complemento;
	private CasoDeUso pontoDeExtensao;
	
	public Passo(int codigo, String acao, String complemento) {
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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
	@JoinColumn(name="idFluxo") //insertable=false, updatable=false
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

	@ManyToOne
	@PrimaryKeyJoinColumn(name="idAtor")
	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	
	@Transient
	public Ator getAtorParaXML() {
		atorParaXML = new Ator();
		atorParaXML.setNome(this.ator.getNome());
		
		return atorParaXML;
	}
	
	public void setAtorParaXML(Ator atorParaXML) {
		this.atorParaXML = atorParaXML;
	}

	public String toString() {
		return "";
	}
	
	@Transient
	public String getPassoAsString() {
		return toString();
	}
}
 
