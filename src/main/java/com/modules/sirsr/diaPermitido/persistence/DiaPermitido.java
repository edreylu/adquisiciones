/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.diaPermitido.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;

    public Date getDiaPermitido() {
        return diaPermitido;
    }

    public void setDiaPermitido(Date diaPermitido) {
        this.diaPermitido = diaPermitido;
    }

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
    
    

}
