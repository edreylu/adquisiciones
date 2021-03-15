/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.seguimientoSolicitud.domain;

import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.solicitud.domain.Solicitud;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "SEGUIMIENTO_SOLICITUD")
public class SeguimientoSolicitud {

    @EmbeddedId
    protected SeguimientoSolicitudPK seguimientoSolicitudPK;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitud solicitud;

    public SeguimientoSolicitud() {
    }

    public SeguimientoSolicitud(SeguimientoSolicitudPK seguimientoSolicitudPK) {
        this.seguimientoSolicitudPK = seguimientoSolicitudPK;
    }

    public SeguimientoSolicitud(int idSolicitud, short idEstatus, Date fecha) {
        this.seguimientoSolicitudPK = new SeguimientoSolicitudPK(idSolicitud, idEstatus, fecha);
    }

    public SeguimientoSolicitudPK getSeguimientoSolicitudPK() {
        return seguimientoSolicitudPK;
    }

    public void setSeguimientoSolicitudPK(SeguimientoSolicitudPK seguimientoSolicitudPK) {
        this.seguimientoSolicitudPK = seguimientoSolicitudPK;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
}
