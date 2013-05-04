package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Entity;

import br.unigranrio.bean.requisito.enums.TipoAtor;

@Entity
public class CasoDeUsoAtor implements Serializable {

	private TipoAtor tipoAtor;
	private Ator ator;
	private CasoDeUso casoDeUso;
	
	public CasoDeUsoAtor() {
		// TODO Auto-generated constructor stub
	}

	public TipoAtor getTipoAtor() {
		return tipoAtor;
	}

	public void setTipoAtor(TipoAtor tipoAtor) {
		this.tipoAtor = tipoAtor;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
}
