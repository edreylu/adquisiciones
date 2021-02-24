/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "INVITACION_A_COTIZAR")
public class InvitacionACotizar {
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INVITACION_A_COTIZAR")
    private Integer idInvitacionACotizar;
    @Basic(optional = false)
    @Column(name = "ID_REQUISICION")
    private int idRequisicion;
    @Basic(optional = false)
    @Column(name = "FECHA_INVITACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInvitacion;
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private int idProveedor;
    @Column(name = "TIEMPO_DE_ENTREGA")
    private Short tiempoDeEntrega;
    @Column(name = "LUGAR_DE_ENTREGA")
    private String lugarDeEntrega;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private short estatus;

    public Integer getIdInvitacionACotizar() {
        return idInvitacionACotizar;
    }

    public void setIdInvitacionACotizar(Integer idInvitacionACotizar) {
        this.idInvitacionACotizar = idInvitacionACotizar;
    }

    public int getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(int idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Date getFechaInvitacion() {
        return fechaInvitacion;
    }

    public void setFechaInvitacion(Date fechaInvitacion) {
        this.fechaInvitacion = fechaInvitacion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Short getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public void setTiempoDeEntrega(Short tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }

    public String getLugarDeEntrega() {
        return lugarDeEntrega;
    }

    public void setLugarDeEntrega(String lugarDeEntrega) {
        this.lugarDeEntrega = lugarDeEntrega;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }
    
}
