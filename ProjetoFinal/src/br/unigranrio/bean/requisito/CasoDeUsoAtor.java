package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.unigranrio.bean.requisito.enums.TipoAtor;


@Entity
@AssociationOverrides( {
		@AssociationOverride(name = "pk.ator", joinColumns = @JoinColumn(name = "ator_id")),
		@AssociationOverride(name = "pk.casoDeUso", joinColumns = @JoinColumn(name = "casoDeUso_id")) })
public class CasoDeUsoAtor {

	private CasoDeUsoAtorPk pk = new CasoDeUsoAtorPk();
	private TipoAtor tipoAtor;

	@EmbeddedId
    private CasoDeUsoAtorPk getPk() {
        return pk;
    }
    private void setPk(CasoDeUsoAtorPk pk) {
        this.pk = pk;
    }	
	
    @Transient    
    public Ator getAtor() {
        return getPk().getAtor();
    }

    public void setAtor(Ator ator) {
        getPk().setAtor(ator);
    }

    @Transient
    public CasoDeUso getCasoDeUso() {
        return getPk().getCasoDeUso();
    }

    public void setCasoDeUso(CasoDeUso casoDeUso) {
        getPk().setCasoDeUso(casoDeUso);
    }

	@Enumerated(EnumType.ORDINAL)
	public TipoAtor getTipoAtor() {
		return tipoAtor;
	}

	public void setTipoAtor(TipoAtor tipoAtor) {
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

@Embeddable
class CasoDeUsoAtorPk implements Serializable {

	private Ator ator = new Ator();
    private CasoDeUso casoDeUso;

    @ManyToOne
    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    @ManyToOne
    public CasoDeUso getCasoDeUso() {
        return casoDeUso;
    }

    public void setCasoDeUso(CasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasoDeUsoAtorPk that = (CasoDeUsoAtorPk) o;

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