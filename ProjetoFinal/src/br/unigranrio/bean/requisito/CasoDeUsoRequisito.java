package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@Entity
@Table(name="casoDeUsoRequisito")
@AssociationOverrides({
	@AssociationOverride(name = "pk.casoDeUso", 
		joinColumns = @JoinColumn(name = "casoDeUso_id")),
	@AssociationOverride(name = "pk.requisito", 
		joinColumns = @JoinColumn(name = "requisito_id")) })
@XStreamAlias("requisito")
public class CasoDeUsoRequisito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XStreamOmitField
	private CasoDeUsoRequisitoId pk = new CasoDeUsoRequisitoId();
	
	@EmbeddedId
	public CasoDeUsoRequisitoId getPk() {
		return pk;
	}

	public void setPk(CasoDeUsoRequisitoId pk) {
		this.pk = pk;
	}
	
	@Transient
	public CasoDeUso getCasoDeUso() {
		return getPk().getCasoDeUso();
	}
	
	public void setCasoDeUso(CasoDeUso casoDeUso) {
		getPk().setCasoDeUso(casoDeUso);
	}
	
	@Transient
	public RequisitoNaoFuncional getRequisito() {
		return getPk().getRequisito();
	}
	
	public void setRequisito(RequisitoNaoFuncional requisito) {
		getPk().setRequisito(requisito);
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoRequisito that = (CasoDeUsoRequisito) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
	
}