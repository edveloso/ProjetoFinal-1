package br.unigranrio.bean.requisito;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.unigranrio.bean.requisito.enums.TipoFluxo;

@Entity
public class Fluxo implements Serializable{
	
	
	private Long id;
	private String nome;
	private TipoFluxo tipo;
	private CasoDeUso casoDeUso;
//	protected List<Passo> passos;
//	protected Passo disparadoPor;
	private int codigo;
	
	public Fluxo() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoFluxo getTipo() {
		return tipo;
	}

	public void setTipo(TipoFluxo tipo) {
		this.tipo = tipo;
	}
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = CasoDeUso.class)
	@PrimaryKeyJoinColumn
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

/*	public List<Passo> getPassos() {
		return passos;
	}

	public void setPassos(List<Passo> passos) {
		this.passos = passos;
	}

	public Passo getDisparadoPor() {
		return disparadoPor;
	}

	public void setDisparadoPor(Passo disparadoPor) {
		this.disparadoPor = disparadoPor;
	}
*/
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
