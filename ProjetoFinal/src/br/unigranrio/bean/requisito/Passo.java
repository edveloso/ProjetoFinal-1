package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "passo") //representa o elemento principal, ou a tag principal do XML.
public class Passo implements Serializable {
 

	private Long id;
	private Integer codigo;
	private Fluxo fluxo = new Fluxo();	
	private List<Ator> atorParaXML = new ArrayList<Ator>();
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

	@ManyToOne
	@JoinColumn(name="idFluxo") //insertable=false, updatable=false
	@XmlElement(name="passo_fluxo")
	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCasoDeUsoExtensao", insertable=false, updatable=false)
	@XmlElement(name="passo_pontoExtensao")
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
	@XmlElementWrapper(name="passo_atores")
	@XmlElement(name="passo_ator")
	public List<Ator> getAtorParaXML() {		
		return atorParaXML;
	}
	
	public void setAtorParaXML(List<Ator> atorParaXML) {
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
 