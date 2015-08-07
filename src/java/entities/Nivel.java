/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByIdNivel", query = "SELECT n FROM Nivel n WHERE n.idNivel = :idNivel"),
    @NamedQuery(name = "Nivel.findByDescripcion", query = "SELECT n FROM Nivel n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "Nivel.findByTieneNotaPresentacion", query = "SELECT n FROM Nivel n WHERE n.tieneNotaPresentacion = :tieneNotaPresentacion"),
    @NamedQuery(name = "Nivel.findByTieneFolio", query = "SELECT n FROM Nivel n WHERE n.tieneFolio = :tieneFolio")})
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdNivel")
    private Integer idNivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneNotaPresentacion")
    private boolean tieneNotaPresentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneFolio")
    private boolean tieneFolio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel")
    private Collection<Estudiantenivel> estudiantenivelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private Collection<Certificacion> certificacionCollection;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Nivel(Integer idNivel, String descripcion, boolean tieneNotaPresentacion, boolean tieneFolio) {
        this.idNivel = idNivel;
        this.descripcion = descripcion;
        this.tieneNotaPresentacion = tieneNotaPresentacion;
        this.tieneFolio = tieneFolio;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getTieneNotaPresentacion() {
        return tieneNotaPresentacion;
    }

    public void setTieneNotaPresentacion(boolean tieneNotaPresentacion) {
        this.tieneNotaPresentacion = tieneNotaPresentacion;
    }

    public boolean getTieneFolio() {
        return tieneFolio;
    }

    public void setTieneFolio(boolean tieneFolio) {
        this.tieneFolio = tieneFolio;
    }

    @XmlTransient
    public Collection<Estudiantenivel> getEstudiantenivelCollection() {
        return estudiantenivelCollection;
    }

    public void setEstudiantenivelCollection(Collection<Estudiantenivel> estudiantenivelCollection) {
        this.estudiantenivelCollection = estudiantenivelCollection;
    }

    @XmlTransient
    public Collection<Certificacion> getCertificacionCollection() {
        return certificacionCollection;
    }

    public void setCertificacionCollection(Collection<Certificacion> certificacionCollection) {
        this.certificacionCollection = certificacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Nivel[ idNivel=" + idNivel + " ]";
    }
    
}
