package br.unigranrio.bean.requisito;

public class Passo {
	
	private Long id;
	private Integer codigo;
	private Fluxo fluxo = new Fluxo();	
	private Ator atorParaXML = new Ator();
	private Ator ator = new Ator();
	private String acao;
	private String complemento;
	private CasoDeUso pontoDeExtensao;
	
	public Passo() {
		// TODO Auto-generated constructor stub
	}

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

	public Fluxo getFluxo() {
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	public Ator getAtorParaXML() {
		return atorParaXML;
	}

	public void setAtorParaXML(Ator atorParaXML) {
		this.atorParaXML = atorParaXML;
	}

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

	public CasoDeUso getPontoDeExtensao() {
		return pontoDeExtensao;
	}

	public void setPontoDeExtensao(CasoDeUso pontoDeExtensao) {
		this.pontoDeExtensao = pontoDeExtensao;
	}
	
}
