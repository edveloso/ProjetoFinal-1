package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Embeddable
public class CasoDeUsoRequisitoId implements Serializable {

	private static final long serialVersionUID = 1L;
	private CasoDeUso casoDeUso;
	
	@XStreamAlias("requisito")
	private RequisitoNaoFuncional requisito;
	
	@ManyToOne
	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
	@ManyToOne
	public RequisitoNaoFuncional getRequisito() {
		return requisito;
	}
	
	public void setRequisito(RequisitoNaoFuncional requisito) {
		this.requisito = requisito;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoRequisitoId that = (CasoDeUsoRequisitoId) o;

        if (requisito != null ? !requisito.equals(that.requisito) : that.requisito != null) return false;
        if (casoDeUso != null ? !casoDeUso.equals(that.casoDeUso) : that.casoDeUso != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (requisito != null ? requisito.hashCode() : 0);
        result = 31 * result + (casoDeUso != null ? casoDeUso.hashCode() : 0);
        return result;
    }
	
}
