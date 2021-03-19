/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.revision.application;

import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.prioridad.application.PrioridadDTO;
import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableDTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class RevisionDTO {
    private Date fechaRevision;
    private String observacion;
    private SolicitudDTO solicitud;

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }
}
