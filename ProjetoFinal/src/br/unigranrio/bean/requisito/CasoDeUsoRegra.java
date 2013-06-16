package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@Entity
@AssociationOverrides({
	@AssociationOverride(name = "pk.casoDeUso", 
		joinColumns = @JoinColumn(name = "casoDeUso_id")),
	@AssociationOverride(name = "pk.regra", 
		joinColumns = @JoinColumn(name = "id")) })
@XStreamAlias("regra")
public class CasoDeUsoRegra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XStreamOmitField
	private CasoDeUsoRegraId pk = new CasoDeUsoRegraId();
	
	@EmbeddedId
	public CasoDeUsoRegraId getPk() {
		return pk;
	}

	public void setPk(CasoDeUsoRegraId pk) {
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
	public RegraDeNegocio getRegra() {
		return getPk().getRegra();
	}
	
	public void setRegra(RegraDeNegocio regra) {
		getPk().setRegra(regra);
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoRegra that = (CasoDeUsoRegra) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
	
}