/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import com.modules.sirsr.marca.MarcaDTO;
import com.modules.sirsr.producto.ProductoDTO;
import java.math.BigDecimal;


/**
 *
 * @author Edward Reyes
 */
public class DetalleRequisicionDTO {
    private Integer idDetalleRequisicion;
    private Integer cantidadSolicitada;
    private BigDecimal precioUnitario;
    private Integer cantidadAutorizada;
    private RequisicionDTO requisicion;
    private MarcaDTO marca;
    private ProductoDTO producto;

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

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidadAutorizada() {
        return cantidadAutorizada;
    }

    public void setCantidadAutorizada(Integer cantidadAutorizada) {
        this.cantidadAutorizada = cantidadAutorizada;
    }

    public RequisicionDTO getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(RequisicionDTO requisicion) {
        this.requisicion = requisicion;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    
}
