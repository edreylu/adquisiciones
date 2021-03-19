/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.application;

import com.modules.sirsr.marca.application.MarcaDTO;
import com.modules.sirsr.producto.application.ProductoDTO;
import com.modules.sirsr.requisicion.application.RequisicionDTO;

import java.math.BigDecimal;


/**
 *
 * @author Edward Reyes
 */
public class DetalleRequisicionDTO {
    private int idDetalleRequisicion;
    private int idRequisicion;
    private int cantidadSolicitada;
    private BigDecimal precioUnitario;
    private int cantidadAutorizada;
    private RequisicionDTO requisicion;
    private MarcaDTO marca;
    private ProductoDTO producto;

    public int getIdDetalleRequisicion() {
        return idDetalleRequisicion;
    }

    public void setIdDetalleRequisicion(int idDetalleRequisicion) {
        this.idDetalleRequisicion = idDetalleRequisicion;
    }

    public int getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(int idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadAutorizada() {
        return cantidadAutorizada;
    }

    public void setCantidadAutorizada(int cantidadAutorizada) {
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
