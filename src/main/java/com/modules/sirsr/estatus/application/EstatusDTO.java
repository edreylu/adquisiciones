/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.estatus.application;

/**
 *
 * @author Edward Reyes
 */
public class EstatusDTO {
    
    private int idEstatus;
    private String clave;
    private String descripcion;
    private String colorhex;
    private String explicacion;

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getColorhex() {
        return colorhex;
    }

    public void setColorhex(String colorhex) {
        this.colorhex = colorhex;
    }

    @Override
    public String toString() {
        return "EstatusDTO{" +
                "idEstatus=" + idEstatus +
                ", clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", colorhex='" + colorhex + '\'' +
                ", explicacion='" + explicacion + '\'' +
                '}';
    }
}