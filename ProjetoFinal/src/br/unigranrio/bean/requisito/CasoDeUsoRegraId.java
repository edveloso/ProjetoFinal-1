package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Embeddable
public class CasoDeUsoRegraId implements Serializable {

	private static final long serialVersionUID = 1L;
	private CasoDeUso casoDeUso;
	
	@XStreamAlias("regra")
	private RegraDeNegocio regra;
	
	@ManyToOne
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
	@ManyToOne
	public RegraDeNegocio getRegra() {
		return regra;
	}
	
	public void setRegra(RegraDeNegocio regra) {
		this.regra = regra;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoRegraId that = (CasoDeUsoRegraId) o;

        if (regra != null ? !regra.equals(that.regra) : that.regra != null) return false;
        if (casoDeUso != null ? !casoDeUso.equals(that.casoDeUso) : that.casoDeUso != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (regra != null ? regra.hashCode() : 0);
        result = 31 * result + (casoDeUso != null ? casoDeUso.hashCode() : 0);
        return result;
    }
	
}
