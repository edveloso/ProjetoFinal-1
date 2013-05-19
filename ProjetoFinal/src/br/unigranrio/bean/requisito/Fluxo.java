package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
public class Fluxo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String tipo;
	private String codigo;
	private CasoDeUso casoDeUso;
	protected List<Passo> passos;
	
	private List<Passo> passosParaXML = new ArrayList<Passo>();
	protected Passo disparadoPor;
	private Passo disparadoPorParaXML;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@ManyToOne
	@PrimaryKeyJoinColumn
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

	@OneToMany(mappedBy="fluxo", cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	public List<Passo> getPassos() {
		return passos;
	}

	public void setPassos(List<Passo> passos) {
		this.passos = passos;
	}

	@Transient
	public List<Passo> getPassosParaXML() {
		return passosParaXML;
	}
	
	public void setPassosParaXML(List<Passo> passosParaXML) {
		this.passosParaXML = passosParaXML;
	}

	public void addPasso(Passo passo) {
		this.passos.add(passo);
	}

	@ManyToOne
	@PrimaryKeyJoinColumn
	public Passo getDisparadoPor() {
		return disparadoPor;
	}

	public void setDisparadoPor(Passo disparadoPor) {
		this.disparadoPor = disparadoPor;
	}
	
	@Transient
	public Passo getDisparadoPorParaXML() {
		return disparadoPorParaXML;
	}
	
	public void setDisparadoPorParaXML(Passo disparadoPor) {
		this.disparadoPorParaXML = disparadoPor;
	}

}
