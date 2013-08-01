package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import br.unigranrio.controller.Exportavel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@Table(name="casoDeUso")
@XStreamAlias("casoDeUso")
public class CasoDeUso implements Serializable, Exportavel {

	private static final long serialVersionUID = 1L;

	@XStreamOmitField
	private Long id;
	private Projeto projeto;
	private String codigo;
	private String nome;
	private String objetivo;
	private String tipo;

	@XStreamAlias("atores")
	private List<Ator> atores = new ArrayList<Ator>();
	@XStreamAlias("fluxos")
	private List<Fluxo> fluxosParaXML = new ArrayList<Fluxo>();
	@XStreamAlias("preCondicoes")
	private List<PreCondicao> preCondicoesParaXML = new ArrayList<PreCondicao>();
	@XStreamAlias("posCondicoes")
	private List<PosCondicao> posCondicoesParaXML = new ArrayList<PosCondicao>();
	@XStreamAlias("regrasDeNegocio")
	private List<RegraDeNegocio> regrasDeNegocioParaXML = new ArrayList<RegraDeNegocio>();
	@XStreamAlias("requisitosNaoFuncionais")
	private List<RequisitoNaoFuncional> requisitosNaoFuncionaisParaXML = new ArrayList<RequisitoNaoFuncional>();

	@XStreamOmitField
	private List<CasoDeUsoAtor> casosDeUsoAtor = new ArrayList<CasoDeUsoAtor>();
	@XStreamOmitField
	private List<CasoDeUsoRegra> casosDeUsoRegra = new ArrayList<CasoDeUsoRegra>();
	@XStreamOmitField
	private List<CasoDeUsoRequisito> casosDeUsoRequisito = new ArrayList<CasoDeUsoRequisito>();
	@XStreamOmitField
	private List<Fluxo> fluxos = new ArrayList<Fluxo>();
	@XStreamOmitField
	private List<RegraDeNegocio> regrasDeNegocio = new ArrayList<RegraDeNegocio>();
	@XStreamOmitField
	private List<PreCondicao> preCondicoes = new ArrayList<PreCondicao>();
	@XStreamOmitField
	private List<PosCondicao> posCondicoes = new ArrayList<PosCondicao>();
	@XStreamOmitField
	private List<RequisitoNaoFuncional> requisitosNaoFuncionais = new ArrayList<RequisitoNaoFuncional>();

	@XStreamOmitField
	@Transient
	private String formato;

	public CasoDeUso() {
	}

	/**
	 * GET e SET dos atributos simples do objeto para persistência.
	 */
	
	@Id
	@GeneratedValue
	@Column(name = "casoDeUso_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	/**
	 * GET e SET dos atributos para escrita do XML
	 */
	@Transient
	public List<Ator> getAtores() {
		for (CasoDeUsoAtor ucAtor : casosDeUsoAtor) {
			Ator ator = ucAtor.getAtor();
			ator.setTipo(ucAtor.getTipoAtor());
			atores.add(ator);
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	@Transient
	public List<Fluxo> getFluxosParaXML() {

		for (Fluxo fluxo : getFluxos()) {
			Fluxo flx = new Fluxo();
			flx.setNome(fluxo.getNome());
			flx.setDisparadoPorParaXML(fluxo.getDisparadoPorParaXML());
			flx.setPassosParaXML(fluxo.getPassosParaXML());
			flx.setTipo(fluxo.getTipo());
			fluxosParaXML.add(flx);
		}

		return fluxosParaXML;
	}

	public void setFluxosParaXML(List<Fluxo> fluxosParaXML) {
		this.fluxosParaXML = fluxosParaXML;
	}
	
	@Transient
	public List<PreCondicao> getPreCondicoesParaXML() {
		for (PreCondicao pre : getPreCondicoes()) {
			PreCondicao preCond = new PreCondicao();
			preCond.setDescricao(pre.getDescricao());
			preCondicoesParaXML.add(preCond);
		}

		return preCondicoesParaXML;
	}

	public void setPreCondicoesParaXML(List<PreCondicao> preCondicoesParaXML) {
		this.preCondicoesParaXML = preCondicoesParaXML;
	}

	@Transient
	public List<PosCondicao> getPosCondicoesParaXML() {
		for (PosCondicao pos : getPosCondicoes()) {
			PosCondicao posCond = new PosCondicao();
			posCond.setDescricao(pos.getDescricao());
			posCondicoesParaXML.add(posCond);
		}

		return posCondicoesParaXML;
	}
	
	public void setPosCondicoesParaXML(List<PosCondicao> posCondicoesParaXML) {
		this.posCondicoesParaXML = posCondicoesParaXML;
	}
	
	@Transient
	public List<RegraDeNegocio> getRegrasDeNegocioParaXML() {
		for (CasoDeUsoRegra rn : getCasosDeUsoRegra()) {
			RegraDeNegocio regra = rn.getRegra();
			regrasDeNegocioParaXML.add(regra);
		}

		return regrasDeNegocioParaXML;
	}

	public void setRegrasDeNegocioParaXML(
			List<RegraDeNegocio> regrasDeNegocioParaXML) {
		this.regrasDeNegocioParaXML = regrasDeNegocioParaXML;
	}
	
	@Transient
	public List<RequisitoNaoFuncional> getRequisitosNaoFuncionaisParaXML() {
		for (CasoDeUsoRequisito rnf : getCasosDeUsoRequisito()) {
			RequisitoNaoFuncional req = rnf.getRequisito();
			req.setCodigo(rnf.getRequisito().getCodigo());
			req.setDescricao(rnf.getRequisito().getDescricao());
			requisitosNaoFuncionaisParaXML.add(req);
		}
		return requisitosNaoFuncionaisParaXML;
	}
	
	public void setRequisitosNaoFuncionaisParaXML(
			List<RequisitoNaoFuncional> requisitosNaoFuncionaisParaXML) {
		this.requisitosNaoFuncionaisParaXML = requisitosNaoFuncionaisParaXML;
	}
	
	
	
	
	/**
	 * GET e SET dos atributos complexos do objeto para persistência.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.casoDeUso", cascade = CascadeType.ALL)
	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.casoDeUso", cascade = CascadeType.ALL)
	public List<CasoDeUsoRegra> getCasosDeUsoRegra() {
		return casosDeUsoRegra;
	}

	public void setCasosDeUsoRegra(List<CasoDeUsoRegra> casosDeUsoRegra) {
		this.casosDeUsoRegra = casosDeUsoRegra;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.casoDeUso", cascade = CascadeType.ALL)
	public List<CasoDeUsoRequisito> getCasosDeUsoRequisito() {
		return casosDeUsoRequisito;
	}

	public void setCasosDeUsoRequisito(List<CasoDeUsoRequisito> casosDeUsoRequisito) {
		this.casosDeUsoRequisito = casosDeUsoRequisito;
	}
	

	

	
	/**
	 * GET e SET dos atributos auxiliares para preenchimento dos atributos complexos de geração de XML
	 */

	@Transient
	public List<Fluxo> getFluxos() {
		return fluxos;
	}

	public void setFluxos(List<Fluxo> fluxos) {
		this.fluxos = fluxos;
	}

	@Transient
	public List<RegraDeNegocio> getRegrasDeNegocio() {
		return regrasDeNegocio;
	}

	public void setRegrasDeNegocio(List<RegraDeNegocio> regrasDeNegocio) {
		this.regrasDeNegocio = regrasDeNegocio;
	}

	@Transient
	public List<PreCondicao> getPreCondicoes() {
		return preCondicoes;
	}

	public void setPreCondicoes(List<PreCondicao> preCondicoes) {
		this.preCondicoes = preCondicoes;
	}

	@Transient
	public List<PosCondicao> getPosCondicoes() {
		return posCondicoes;
	}

	public void setPosCondicoes(List<PosCondicao> posCondicoes) {
		this.posCondicoes = posCondicoes;
	}

	@Transient
	public List<RequisitoNaoFuncional> getRequisitosNaoFuncionais() {
		return requisitosNaoFuncionais;
	}

	public void setRequisitosNaoFuncionais(
			List<RequisitoNaoFuncional> requisitosNaoFuncionais) {
		this.requisitosNaoFuncionais = requisitosNaoFuncionais;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	
}
