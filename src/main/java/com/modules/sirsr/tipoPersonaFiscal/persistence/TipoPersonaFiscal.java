/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoPersonaFiscal.persistence;

import com.modules.sirsr.proveedor.persistence.Proveedor;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "TIPO_PERSONA_FISCAL")
public class TipoPersonaFiscal {

    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PERSONA_FISCAL")
    private Integer idTipoPersonaFiscal;
    
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "ID_ESTATUS")
    private Integer idEstatus;
    
    @OneToMany(mappedBy = "tipoPersonaFiscal")
    private List<Proveedor> proveedores;

    public Integer getIdTipoPersonaFiscal() {
        return idTipoPersonaFiscal;
    }

    public void setIdTipoPersonaFiscal(Integer idTipoPersonaFiscal) {
        this.idTipoPersonaFiscal = idTipoPersonaFiscal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    
}
