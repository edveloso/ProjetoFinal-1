package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;


@Entity
@AssociationOverrides({
	@AssociationOverride(name = "pk.casoDeUso", 
		joinColumns = @JoinColumn(name = "casoDeUso_id")),
	@AssociationOverride(name = "pk.ator", 
		joinColumns = @JoinColumn(name = "ator_id")) })
public class CasoDeUsoAtor implements Serializable{

	private static final long serialVersionUID = 1L;
	private CasoDeUsoAtorId pk = new CasoDeUsoAtorId();
	private String tipoAtor;
	
	@EmbeddedId
	public CasoDeUsoAtorId getPk() {
		return pk;
	}

	public void setPk(CasoDeUsoAtorId pk) {
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
	public Ator getAtor() {
		return getPk().getAtor();
	}
	
	public void setAtor(Ator ator) {
		getPk().setAtor(ator);
	}

	public String getTipoAtor() {
		return tipoAtor;
	}
	
	public void setTipoAtor(String tipoAtor) {
		this.tipoAtor = tipoAtor;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoAtor that = (CasoDeUsoAtor) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
	
}