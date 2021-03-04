/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import com.modules.sirsr.subTipoProducto.SubTipoProductoDTO;
import com.modules.sirsr.unidadMedida.UnidadMedidaDTO;
import com.modules.sirsr.volante.VolanteDTO;

/**
 *
 * @author Edward Reyes
 */
public class DetalleRequisicionDTO {
    private Integer idDetalleRequisicion;
    private Integer cantidadSolicitada;
    private String caracteristicas;
    private String digito;
    private Integer cantidadAutorizada;
    private VolanteDTO volante;
    private UnidadMedidaDTO unidadMedida;
    private SubTipoProductoDTO subtipoProducto;

    public Integer getIdDetalleRequisicion() {
        return idDetalleRequisicion;
    }

    public void setIdDetalleRequisicion(Integer idDetalleRequisicion) {
        this.idDetalleRequisicion = idDetalleRequisicion;
    }

    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public Integer getCantidadAutorizada() {
        return cantidadAutorizada;
    }

    public void setCantidadAutorizada(Integer cantidadAutorizada) {
        this.cantidadAutorizada = cantidadAutorizada;
    }

    public VolanteDTO getVolante() {
        return volante;
    }

    public void setVolante(VolanteDTO volante) {
        this.volante = volante;
    }
    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public SubTipoProductoDTO getSubtipoProducto() {
        return subtipoProducto;
    }

    public void setSubtipoProducto(SubTipoProductoDTO subtipoProducto) {
        this.subtipoProducto = subtipoProducto;
    }
}
