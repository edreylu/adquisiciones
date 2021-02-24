/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.requisicion;

/**
 *
 * @author Edward Reyes
 */
public class Requisicion {
    private int folio;
    private int areaSolicitante;
    private int cantidad;
    private int unidad;
    private String clavePresupuestal;
    private int objetoGasto;
    private String descripcionProducto;
    private int digito;

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getAreaSolicitante() {
        return areaSolicitante;
    }

    public void setAreaSolicitante(int areaSolicitante) {
        this.areaSolicitante = areaSolicitante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public String getClavePresupuestal() {
        return clavePresupuestal;
    }

    public void setClavePresupuestal(String clavePresupuestal) {
        this.clavePresupuestal = clavePresupuestal;
    }

    public int getObjetoGasto() {
        return objetoGasto;
    }

    public void setObjetoGasto(int objetoGasto) {
        this.objetoGasto = objetoGasto;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    
    
    
}
