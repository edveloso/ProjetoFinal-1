package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement(name = "casoDeUso") //representa o elemento principal, ou a tag principal do XML.
@XmlType(propOrder = { "id", "projeto", "codigo", "nome", "objetivo", "tipo", "atores", "casosDeUsoAtor", "fluxos", "regrasDeNegocio", "preCondicoes", "posCondicoes", "requisitosNaoFuncionais"})
public class CasoDeUso implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private Long id;
	private Projeto projeto;
	private String codigo;
	private String nome;
	private String objetivo;
	private String tipo;

	private List<Ator> atores = new ArrayList<Ator>();
	private List<CasoDeUsoAtor> casosDeUsoAtor = new ArrayList<CasoDeUsoAtor>();
	private List<Fluxo> fluxos = new ArrayList<Fluxo>();
	private List<RegraDeNegocio> regrasDeNegocio = new ArrayList<RegraDeNegocio>();
	private List<PreCondicao> preCondicoes = new ArrayList<PreCondicao>();
	private List<PosCondicao> posCondicoes = new ArrayList<PosCondicao>();
	private List<RequisitoNaoFuncional> requisitosNaoFuncionais = new ArrayList<RequisitoNaoFuncional>();

	public CasoDeUso() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="casoDeUso_id")
	@XmlElement(name="casoDeUso_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Projeto.class)
	@PrimaryKeyJoinColumn
	@XmlElement(name="casoDeUso_projeto")
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	@XmlElement(name="casoDeUso_codigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@XmlElement(name="casoDeUso_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@XmlElement(name="casoDeUso_objetivo")
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	@XmlElement(name="casoDeUso_tipo")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_atores")
	@XmlElement(name="casoDeUso_ator")
	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_casosAtores")
	@XmlElement(name="casoDeUso_casosAtor")
	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_fluxos")
	@XmlElement(name="casoDeUso_fluxo")
	public List<Fluxo> getFluxos() {
		return fluxos;
	}

	public void setFluxos(List<Fluxo> fluxos) {
		this.fluxos = fluxos;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_regras")
	@XmlElement(name="casoDeUso_regra")
	public List<RegraDeNegocio> getRegrasDeNegocio() {
		return regrasDeNegocio;
	}

	public void setRegrasDeNegocio(List<RegraDeNegocio> regrasDeNegocio) {
		this.regrasDeNegocio = regrasDeNegocio;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_precondicoes")
	@XmlElement(name="casoDeUso_pre")
	public List<PreCondicao> getPreCondicoes() {
		return preCondicoes;
	}

	public void setPreCondicoes(List<PreCondicao> preCondicoes) {
		this.preCondicoes = preCondicoes;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_poscondicoes")
	@XmlElement(name="casoDeUso_pos")
	public List<PosCondicao> getPosCondicoes() {
		return posCondicoes;
	}

	public void setPosCondicoes(List<PosCondicao> posCondicoes) {
		this.posCondicoes = posCondicoes;
	}
	
	@Transient
	@XmlElementWrapper(name="casoDeUso_requisitos")
	@XmlElement(name="casoDeUso_requisito")
	public List<RequisitoNaoFuncional> getRequisitosNaoFuncionais() {
		return requisitosNaoFuncionais;
	}

	public void setRequisitosNaoFuncionais(
			List<RequisitoNaoFuncional> requisitosNaoFuncionais) {
		this.requisitosNaoFuncionais = requisitosNaoFuncionais;
	}
	
	public void addAtor(Ator ator){
		if(atores==null) 
			atores = new ArrayList<Ator>();
			atores.add(ator);
			
	}
	
	public void addCasosDeUsoAtor(CasoDeUsoAtor casoDeUsoAtor){
		if(casosDeUsoAtor==null) 
			casosDeUsoAtor = new ArrayList<CasoDeUsoAtor>();
		casosDeUsoAtor.add(casoDeUsoAtor);
			
	}
	
	public void addFluxos(Fluxo fluxo){
		if(fluxos==null)
			fluxos = new ArrayList<Fluxo>();
		fluxos.add(fluxo);
	}
	
	public void addRegrasDeNegocio(RegraDeNegocio regraDeNegocio){
		if(regrasDeNegocio==null)
			regrasDeNegocio = new ArrayList<RegraDeNegocio>();
		regrasDeNegocio.add(regraDeNegocio);
	}

	public void addPreCondicoes(PreCondicao preCondicao){
		if(preCondicoes==null)
			preCondicoes = new ArrayList<PreCondicao>();
		preCondicoes.add(preCondicao);
	}
	
	public void addPosCondicoes(PosCondicao posCondicao){
		if(posCondicoes==null)
			posCondicoes = new ArrayList<PosCondicao>();
		posCondicoes.add(posCondicao);
	}
	
	public void addRequisitosNaoFuncionais(RequisitoNaoFuncional requisitoNaoFuncional){
		if(requisitosNaoFuncionais==null)
			requisitosNaoFuncionais = new ArrayList<RequisitoNaoFuncional>();
		requisitosNaoFuncionais.add(requisitoNaoFuncional);
	}

}
