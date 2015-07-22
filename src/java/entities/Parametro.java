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
@Table(name = "parametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p"),
    @NamedQuery(name = "Parametro.findByDireccionRegional", query = "SELECT p FROM Parametro p WHERE p.direccionRegional = :direccionRegional"),
    @NamedQuery(name = "Parametro.findByCodigoColegio", query = "SELECT p FROM Parametro p WHERE p.codigoColegio = :codigoColegio"),
    @NamedQuery(name = "Parametro.findByNombreColegio", query = "SELECT p FROM Parametro p WHERE p.nombreColegio = :nombreColegio"),
    @NamedQuery(name = "Parametro.findByMensajeEncabezado", query = "SELECT p FROM Parametro p WHERE p.mensajeEncabezado = :mensajeEncabezado"),
    @NamedQuery(name = "Parametro.findByCircuito", query = "SELECT p FROM Parametro p WHERE p.circuito = :circuito"),
    @NamedQuery(name = "Parametro.findByCodigoCertificacion", query = "SELECT p FROM Parametro p WHERE p.codigoCertificacion = :codigoCertificacion"),
    @NamedQuery(name = "Parametro.findByCorreoColegio", query = "SELECT p FROM Parametro p WHERE p.correoColegio = :correoColegio"),
    @NamedQuery(name = "Parametro.findByTelefonoColegio", query = "SELECT p FROM Parametro p WHERE p.telefonoColegio = :telefonoColegio"),
    @NamedQuery(name = "Parametro.findByIdParametro", query = "SELECT p FROM Parametro p WHERE p.idParametro = :idParametro")})
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "DireccionRegional")
    private String direccionRegional;
    @Size(max = 45)
    @Column(name = "CodigoColegio")
    private String codigoColegio;
    @Size(max = 150)
    @Column(name = "NombreColegio")
    private String nombreColegio;
    @Size(max = 200)
    @Column(name = "MensajeEncabezado")
    private String mensajeEncabezado;
    @Size(max = 45)
    @Column(name = "Circuito")
    private String circuito;
    @Size(max = 45)
    @Column(name = "CodigoCertificacion")
    private String codigoCertificacion;
    @Size(max = 45)
    @Column(name = "CorreoColegio")
    private String correoColegio;
    @Size(max = 45)
    @Column(name = "TelefonoColegio")
    private String telefonoColegio;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idParametro")
    private Integer idParametro;
    @JoinColumn(name = "IdDistrito", referencedColumnName = "IdDistrito")
    @ManyToOne
    private Distrito idDistrito;

    public Parametro() {
    }

    public Parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getDireccionRegional() {
        return direccionRegional;
    }

    public void setDireccionRegional(String direccionRegional) {
        this.direccionRegional = direccionRegional;
    }

    public String getCodigoColegio() {
        return codigoColegio;
    }

    public void setCodigoColegio(String codigoColegio) {
        this.codigoColegio = codigoColegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public String getMensajeEncabezado() {
        return mensajeEncabezado;
    }

    public void setMensajeEncabezado(String mensajeEncabezado) {
        this.mensajeEncabezado = mensajeEncabezado;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getCodigoCertificacion() {
        return codigoCertificacion;
    }

    public void setCodigoCertificacion(String codigoCertificacion) {
        this.codigoCertificacion = codigoCertificacion;
    }

    public String getCorreoColegio() {
        return correoColegio;
    }

    public void setCorreoColegio(String correoColegio) {
        this.correoColegio = correoColegio;
    }

    public String getTelefonoColegio() {
        return telefonoColegio;
    }

    public void setTelefonoColegio(String telefonoColegio) {
        this.telefonoColegio = telefonoColegio;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Distrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distrito idDistrito) {
        this.idDistrito = idDistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Parametro[ idParametro=" + idParametro + " ]";
    }
    
}
