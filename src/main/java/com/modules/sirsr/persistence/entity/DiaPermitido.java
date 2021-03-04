/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "DIA_PERMITIDO")
@NamedQueries({
    @NamedQuery(name = "DiaPermitido.findAll", query = "SELECT d FROM DiaPermitido d")})
public class DiaPermitido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DIA_PERMITIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaPermitido;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private short estatus;

    public DiaPermitido() {
    }

    public DiaPermitido(Date diaPermitido) {
        this.diaPermitido = diaPermitido;
    }

    public DiaPermitido(Date diaPermitido, short estatus) {
        this.diaPermitido = diaPermitido;
        this.estatus = estatus;
    }

    public Date getDiaPermitido() {
        return diaPermitido;
    }

    public void setDiaPermitido(Date diaPermitido) {
        this.diaPermitido = diaPermitido;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaPermitido != null ? diaPermitido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaPermitido)) {
            return false;
        }
        DiaPermitido other = (DiaPermitido) object;
        if ((this.diaPermitido == null && other.diaPermitido != null) || (this.diaPermitido != null && !this.diaPermitido.equals(other.diaPermitido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.sirsr.persistence.entity.DiaPermitido[ diaPermitido=" + diaPermitido + " ]";
    }
    
}
