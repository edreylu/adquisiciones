/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento;

import com.modules.sirsr.requisicion.RequisicionDTO;
import java.sql.Blob;
import java.util.Date;

import com.modules.sirsr.tipoDocumento.TipoDocumentoDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Edward Reyes
 */
public class DocumentoDTO {
    private Integer idDocumento;
    private Blob documento;
    private Date fechaActualizacion;
    private RequisicionDTO requisicion;
    private TipoDocumentoDTO tipoDocumento;
    private MultipartFile file;

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Blob getDocumento() {
        return documento;
    }

    public void setDocumento(Blob documento) {
        this.documento = documento;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public RequisicionDTO getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(RequisicionDTO requisicion) {
        this.requisicion = requisicion;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    
}
