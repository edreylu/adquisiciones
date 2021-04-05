/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.folioRequisicion.persistence;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.modules.sirsr.estatus.persistence.Estatus;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "FOLIO_REQUISICION")
public class FolioRequisicion {

    @Id
    @Basic(optional = false)
    @Column(name = "ANIO")
    private Integer anio;
    @Basic(optional = false)
    @Column(name = "CONSECUTIVO")
    private Integer consecutivo;
    
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
    
    

    
}
