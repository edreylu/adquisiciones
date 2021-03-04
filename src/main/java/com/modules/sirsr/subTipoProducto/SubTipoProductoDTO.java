/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.subTipoProducto;

import com.modules.sirsr.PartidaGasto.ObjetoDeGastoDTO;
import com.modules.sirsr.persistence.entity.ObjetoDeGasto;
import com.modules.sirsr.persistence.entity.TipoProducto;
import com.modules.sirsr.tipoProducto.TipoProductoDTO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Edward Reyes
 */
public class SubTipoProductoDTO {
    private int idSubtipoProducto;
    private String descripcion;
    private int estatus;
    private ObjetoDeGastoDTO objetoDeGasto;
    private TipoProductoDTO tipoProducto;

    public int getIdSubtipoProducto() {
        return idSubtipoProducto;
    }

    public void setIdSubtipoProducto(int idSubtipoProducto) {
        this.idSubtipoProducto = idSubtipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public ObjetoDeGastoDTO getObjetoDeGasto() {
        return objetoDeGasto;
    }

    public void setObjetoDeGasto(ObjetoDeGastoDTO objetoDeGasto) {
        this.objetoDeGasto = objetoDeGasto;
    }

    public TipoProductoDTO getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProductoDTO tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
