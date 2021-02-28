/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento;

/**
 *
 * @author Edward Reyes
 */
public class TipoDocumentoDTO {
    private Integer idTipoDocumento;
    private String descripcion;
    private short idEstatus;

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(short idEstatus) {
        this.idEstatus = idEstatus;
    }
    
    
    
}
