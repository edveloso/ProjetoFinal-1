package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.unigranrio.bean.requisito.enums.TipoFluxo;

@Entity
@XmlRootElement(name = "fluxo") //representa o elemento principal, ou a tag principal do XML.
public class Fluxo implements Serializable{
	
	
	private Long id;
	private String nome;
	private TipoFluxo tipo;
	private CasoDeUso casoDeUso;
	protected List<Passo> passos;
	protected Passo disparadoPor;
	private int codigo;
	
	public Fluxo() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@XmlElement(name="fluxo_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="fluxo_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Enumerated(EnumType.ORDINAL)
	@XmlElement(name="fluxo_tipo")
	public TipoFluxo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFluxo tipo) {
		this.tipo = tipo;
	}
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = CasoDeUso.class)
	@PrimaryKeyJoinColumn
	@XmlElement(name="fluxo_casoDeUso")
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	@XmlElementWrapper(name="fluxo_passos")
	@XmlElement(name="fluxo_passo")
	public List<Passo> getPassos() {
		return passos;
	}

	public void setPassos(List<Passo> passos) {
		this.passos = passos;
	}
	
	@XmlElement(name="fluxo_disparadoPor")
	public Passo getDisparadoPor() {
		return disparadoPor;
	}

	public void setDisparadoPor(Passo disparadoPor) {
		this.disparadoPor = disparadoPor;
	}

	@Transient
	@XmlElement(name="fluxo_codigo")
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void addPassos(Passo passo){
		if(passos==null)
			passos = new ArrayList<Passo>();
		passos.add(passo);
	}

}
