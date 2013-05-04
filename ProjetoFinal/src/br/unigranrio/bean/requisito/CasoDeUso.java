package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.unigranrio.bean.requisito.enums.TipoCasoDeUso;

@Entity
public class CasoDeUso implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private Long id;
	private Projeto projeto;
	private String codigo;
	private String nome;
	private String objetivo;
	private TipoCasoDeUso tipo;

/*	private List<Ator> atores = new ArrayList<Ator>();
	private List<CasoDeUsoAtor> casosDeUsoAtor = new ArrayList<CasoDeUsoAtor>();
	private List<Fluxo> fluxos = new ArrayList<Fluxo>();
	private List<RegraDeNegocio> regrasDeNegocio = new ArrayList<RegraDeNegocio>();
	private List<PreCondicao> preCondicoes = new ArrayList<PreCondicao>();
	private List<PosCondicao> posCondicoes = new ArrayList<PosCondicao>();
	private List<RequisitoNaoFuncional> requisitosNaoFuncionais = new ArrayList<RequisitoNaoFuncional>();*/

	public CasoDeUso() {
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

	public TipoCasoDeUso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCasoDeUso tipo) {
		this.tipo = tipo;
	}

/*	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public List<CasoDeUsoAtor> getCasosDeUsoAtor() {
		return casosDeUsoAtor;
	}

	public void setCasosDeUsoAtor(List<CasoDeUsoAtor> casosDeUsoAtor) {
		this.casosDeUsoAtor = casosDeUsoAtor;
	}

	public List<Fluxo> getFluxos() {
		return fluxos;
	}

	public void setFluxos(List<Fluxo> fluxos) {
		this.fluxos = fluxos;
	}

	public List<RegraDeNegocio> getRegrasDeNegocio() {
		return regrasDeNegocio;
	}

	public void setRegrasDeNegocio(List<RegraDeNegocio> regrasDeNegocio) {
		this.regrasDeNegocio = regrasDeNegocio;
	}

	public List<PreCondicao> getPreCondicoes() {
		return preCondicoes;
	}

	public void setPreCondicoes(List<PreCondicao> preCondicoes) {
		this.preCondicoes = preCondicoes;
	}

	public List<PosCondicao> getPosCondicoes() {
		return posCondicoes;
	}

	public void setPosCondicoes(List<PosCondicao> posCondicoes) {
		this.posCondicoes = posCondicoes;
	}

	public List<RequisitoNaoFuncional> getRequisitosNaoFuncionais() {
		return requisitosNaoFuncionais;
	}

	public void setRequisitosNaoFuncionais(
			List<RequisitoNaoFuncional> requisitosNaoFuncionais) {
		this.requisitosNaoFuncionais = requisitosNaoFuncionais;
	}*/

}
