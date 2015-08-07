/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author D0R14N
 */
@Entity
@Table(name = "estudiantenivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantenivel.findAll", query = "SELECT e FROM Estudiantenivel e"),
    @NamedQuery(name = "Estudiantenivel.findByIdEstudiante", query = "SELECT e FROM Estudiantenivel e WHERE e.estudiantenivelPK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiantenivel.findByIdNivel", query = "SELECT e FROM Estudiantenivel e WHERE e.estudiantenivelPK.idNivel = :idNivel"),
    @NamedQuery(name = "Estudiantenivel.findByPromedioPonderado", query = "SELECT e FROM Estudiantenivel e WHERE e.promedioPonderado = :promedioPonderado"),
    @NamedQuery(name = "Estudiantenivel.findByNotaPresentacion", query = "SELECT e FROM Estudiantenivel e WHERE e.notaPresentacion = :notaPresentacion"),
    @NamedQuery(name = "Estudiantenivel.findByTomo", query = "SELECT e FROM Estudiantenivel e WHERE e.tomo = :tomo"),
    @NamedQuery(name = "Estudiantenivel.findByActa", query = "SELECT e FROM Estudiantenivel e WHERE e.acta = :acta"),
    @NamedQuery(name = "Estudiantenivel.findByFolio", query = "SELECT e FROM Estudiantenivel e WHERE e.folio = :folio"),
    @NamedQuery(name = "Estudiantenivel.findByTitulo", query = "SELECT e FROM Estudiantenivel e WHERE e.titulo = :titulo")})
public class Estudiantenivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantenivelPK estudiantenivelPK;
    @Column(name = "PromedioPonderado")
    private BigInteger promedioPonderado;
    @Column(name = "NotaPresentacion")
    private BigInteger notaPresentacion;
    @Size(max = 45)
    @Column(name = "Tomo")
    private String tomo;
    @Size(max = 45)
    @Column(name = "Acta")
    private String acta;
    @Size(max = 45)
    @Column(name = "Folio")
    private String folio;
    @Size(max = 45)
    @Column(name = "Titulo")
    private String titulo;
    @JoinColumn(name = "IdEstudiante", referencedColumnName = "IdEstudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "IdNivel", referencedColumnName = "IdNivel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nivel nivel;

    public Estudiantenivel() {
    }

    public Estudiantenivel(EstudiantenivelPK estudiantenivelPK) {
        this.estudiantenivelPK = estudiantenivelPK;
    }

    public Estudiantenivel(int idEstudiante, int idNivel) {
        this.estudiantenivelPK = new EstudiantenivelPK(idEstudiante, idNivel);
    }

    public EstudiantenivelPK getEstudiantenivelPK() {
        return estudiantenivelPK;
    }

    public void setEstudiantenivelPK(EstudiantenivelPK estudiantenivelPK) {
        this.estudiantenivelPK = estudiantenivelPK;
    }

    public BigInteger getPromedioPonderado() {
        return promedioPonderado;
    }

    public void setPromedioPonderado(BigInteger promedioPonderado) {
        this.promedioPonderado = promedioPonderado;
    }

    public BigInteger getNotaPresentacion() {
        return notaPresentacion;
    }

    public void setNotaPresentacion(BigInteger notaPresentacion) {
        this.notaPresentacion = notaPresentacion;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiantenivelPK != null ? estudiantenivelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantenivel)) {
            return false;
        }
        Estudiantenivel other = (Estudiantenivel) object;
        if ((this.estudiantenivelPK == null && other.estudiantenivelPK != null) || (this.estudiantenivelPK != null && !this.estudiantenivelPK.equals(other.estudiantenivelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estudiantenivel[ estudiantenivelPK=" + estudiantenivelPK + " ]";
    }
    
}
