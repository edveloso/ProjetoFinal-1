package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlElement;


@Entity
public class CasoDeUsoAtor implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private Ator ator = new Ator();
	private CasoDeUso casoDeUso = new CasoDeUso();
	private String tipoAtor;
	
	@Id
	@GeneratedValue
	@Column(name="casoAtor_id")
	@XmlElement(name="casoAtor_id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn(referencedColumnName="ator_id")
	public Ator getAtor() {
		return ator;
	}
	
	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn(referencedColumnName="casoDeUso_id")
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

	public String getTipoAtor() {
		return tipoAtor;
	}
	
	public void setTipoAtor(String tipoAtor) {
		this.tipoAtor = tipoAtor;
	}
	
}