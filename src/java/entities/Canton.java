/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. es un test
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author D0R14N
 */
@Entity
@Table(name = "canton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canton.findAll", query = "SELECT c FROM Canton c"),
    @NamedQuery(name = "Canton.findByIdCanton", query = "SELECT c FROM Canton c WHERE c.idCanton = :idCanton"),
    @NamedQuery(name = "Canton.findByDescripcion", query = "SELECT c FROM Canton c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Canton.findByCodigoTSE", query = "SELECT c FROM Canton c WHERE c.codigoTSE = :codigoTSE")})
public class Canton implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCanton")
    private Integer idCanton;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "CodigoTSE")
    private String codigoTSE;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCanton")
    private Collection<Distrito> distritoCollection;
    @JoinColumn(name = "IdProvincia", referencedColumnName = "IdProvincia")
    @ManyToOne(optional = false)
    private Provincia idProvincia;

    public Canton() {
    }

    public Canton(Integer idCanton) {
        this.idCanton = idCanton;
    }

    public Canton(Integer idCanton, String descripcion) {
        this.idCanton = idCanton;
        this.descripcion = descripcion;
    }

    public Integer getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Integer idCanton) {
        this.idCanton = idCanton;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoTSE() {
        return codigoTSE;
    }

    public void setCodigoTSE(String codigoTSE) {
        this.codigoTSE = codigoTSE;
    }

    @XmlTransient
    public Collection<Distrito> getDistritoCollection() {
        return distritoCollection;
    }

    public void setDistritoCollection(Collection<Distrito> distritoCollection) {
        this.distritoCollection = distritoCollection;
    }

    public Provincia getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Provincia idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCanton != null ? idCanton.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canton)) {
            return false;
        }
        Canton other = (Canton) object;
        if ((this.idCanton == null && other.idCanton != null) || (this.idCanton != null && !this.idCanton.equals(other.idCanton))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Canton[ idCanton=" + idCanton + " ]";
    }
    
}
