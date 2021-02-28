/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento;

import com.modules.sirsr.requisicion.RequisicionDTO;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class DocumentoDTO {
    private Integer idDocumento;
    private Blob documento;
    private Date fechaActualizacion;
    private RequisicionDTO requisicionDTO;
    private TipoDocumentoDTO tipoDocumentoDTO;

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

    public RequisicionDTO getRequisicionDTO() {
        return requisicionDTO;
    }

    public void setRequisicionDTO(RequisicionDTO requisicionDTO) {
        this.requisicionDTO = requisicionDTO;
    }

    public TipoDocumentoDTO getTipoDocumentoDTO() {
        return tipoDocumentoDTO;
    }

    public void setTipoDocumentoDTO(TipoDocumentoDTO tipoDocumentoDTO) {
        this.tipoDocumentoDTO = tipoDocumentoDTO;
    }
    
    
    
}
