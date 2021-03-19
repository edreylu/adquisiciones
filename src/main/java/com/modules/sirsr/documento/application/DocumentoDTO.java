/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento.application;

import java.sql.Blob;
import java.util.Date;

import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.tipoDocumento.application.TipoDocumentoDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Edward Reyes
 */
public class DocumentoDTO {
    private Integer idDocumento;
    private byte[] documento;
    private Date fechaActualizacion;
    private SolicitudDTO solicitud;
    private TipoDocumentoDTO tipoDocumento;
    private MultipartFile file;

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
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
