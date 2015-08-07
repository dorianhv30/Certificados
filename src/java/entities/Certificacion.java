/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author D0R14N
 */
@Entity
@Table(name = "certificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificacion.findAll", query = "SELECT c FROM Certificacion c"),
    @NamedQuery(name = "Certificacion.findByIdCertificacion", query = "SELECT c FROM Certificacion c WHERE c.idCertificacion = :idCertificacion"),
    @NamedQuery(name = "Certificacion.findByDescripcion", query = "SELECT c FROM Certificacion c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Certificacion.findByCodigoPlantilla", query = "SELECT c FROM Certificacion c WHERE c.codigoPlantilla = :codigoPlantilla"),
    @NamedQuery(name = "Certificacion.findByTituloEnPlantilla", query = "SELECT c FROM Certificacion c WHERE c.tituloEnPlantilla = :tituloEnPlantilla"),
    @NamedQuery(name = "Certificacion.findByTieneInfoFolio", query = "SELECT c FROM Certificacion c WHERE c.tieneInfoFolio = :tieneInfoFolio")})
public class Certificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCertificacion")
    private Integer idCertificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CodigoPlantilla")
    private String codigoPlantilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TituloEnPlantilla")
    private String tituloEnPlantilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TieneInfoFolio")
    private boolean tieneInfoFolio;
    @JoinColumn(name = "IdNivel", referencedColumnName = "IdNivel")
    @ManyToOne(optional = false)
    private Nivel idNivel;

    public Certificacion() {
    }

    public Certificacion(Integer idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public Certificacion(Integer idCertificacion, String descripcion, String codigoPlantilla, String tituloEnPlantilla, boolean tieneInfoFolio) {
        this.idCertificacion = idCertificacion;
        this.descripcion = descripcion;
        this.codigoPlantilla = codigoPlantilla;
        this.tituloEnPlantilla = tituloEnPlantilla;
        this.tieneInfoFolio = tieneInfoFolio;
    }

    public Integer getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(Integer idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoPlantilla() {
        return codigoPlantilla;
    }

    public void setCodigoPlantilla(String codigoPlantilla) {
        this.codigoPlantilla = codigoPlantilla;
    }

    public String getTituloEnPlantilla() {
        return tituloEnPlantilla;
    }

    public void setTituloEnPlantilla(String tituloEnPlantilla) {
        this.tituloEnPlantilla = tituloEnPlantilla;
    }

    public boolean getTieneInfoFolio() {
        return tieneInfoFolio;
    }

    public void setTieneInfoFolio(boolean tieneInfoFolio) {
        this.tieneInfoFolio = tieneInfoFolio;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCertificacion != null ? idCertificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificacion)) {
            return false;
        }
        Certificacion other = (Certificacion) object;
        if ((this.idCertificacion == null && other.idCertificacion != null) || (this.idCertificacion != null && !this.idCertificacion.equals(other.idCertificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Certificacion[ idCertificacion=" + idCertificacion + " ]";
    }
    
}
