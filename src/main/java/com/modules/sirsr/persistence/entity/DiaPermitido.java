/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "DIA_PERMITIDO")
public class DiaPermitido {

    @Id
    @Basic(optional = false)
    @Column(name = "DIA_PERMITIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaPermitido;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private short estatus;

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

    
}
