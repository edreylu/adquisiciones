/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.revision.domain;

import com.modules.sirsr.revision.persistence.RevisionPK;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import java.util.Date;

/**
 *
 * @author Edward Reyes
 */
public class RevisionDTO {
	
	private Date fechaRevision;
	private String observacion;
	private SolicitudDTO solicitud;
	
	public RevisionDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public RevisionDTO(Date fechaRevision, String observacion, SolicitudDTO solicitud) {
		super();
		this.fechaRevision = fechaRevision;
		this.observacion = observacion;
		this.solicitud = solicitud;
	}


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
