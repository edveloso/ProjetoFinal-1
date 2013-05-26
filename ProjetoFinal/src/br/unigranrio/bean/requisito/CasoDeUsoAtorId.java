package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Embeddable
public class CasoDeUsoAtorId implements Serializable {

	private static final long serialVersionUID = 1L;
	private CasoDeUso casoDeUso;
	
	@XStreamAlias("ator")
	private Ator ator;
	
	@ManyToOne
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
	@ManyToOne
	public Ator getAtor() {
		return ator;
	}
	
	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoAtorId that = (CasoDeUsoAtorId) o;

        if (ator != null ? !ator.equals(that.ator) : that.ator != null) return false;
        if (casoDeUso != null ? !casoDeUso.equals(that.casoDeUso) : that.casoDeUso != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (ator != null ? ator.hashCode() : 0);
        result = 31 * result + (casoDeUso != null ? casoDeUso.hashCode() : 0);
        return result;
    }
	
}
