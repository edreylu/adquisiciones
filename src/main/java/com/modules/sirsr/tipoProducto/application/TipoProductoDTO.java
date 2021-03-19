package com.modules.sirsr.tipoProducto.application;


import com.modules.sirsr.estatus.application.EstatusDTO;

public class TipoProductoDTO {
    private int idTipoProducto;
    private String descripcion;
    private EstatusDTO estatus;

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }
}
