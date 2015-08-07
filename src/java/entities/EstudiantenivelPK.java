/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author D0R14N
 */
@Embeddable
public class EstudiantenivelPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEstudiante")
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdNivel")
    private int idNivel;

    public EstudiantenivelPK() {
    }

    public EstudiantenivelPK(int idEstudiante, int idNivel) {
        this.idEstudiante = idEstudiante;
        this.idNivel = idNivel;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstudiante;
        hash += (int) idNivel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantenivelPK)) {
            return false;
        }
        EstudiantenivelPK other = (EstudiantenivelPK) object;
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        if (this.idNivel != other.idNivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EstudiantenivelPK[ idEstudiante=" + idEstudiante + ", idNivel=" + idNivel + " ]";
    }
    
}
