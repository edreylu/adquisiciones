/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "INVITACION_A_COTIZAR_REQUIS")
public class InvitacionACotizarRequis {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_INVITA_COTIZAR_REQUIS")
    private Integer idInvitaCotizarRequis;
    @Basic(optional = false)
    @Column(name = "FECHA_INVITACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInvitacion;
    @Column(name = "TIEMPO_DE_ENTREGA")
    private Integer tiempoDeEntrega;
    @Column(name = "LUGAR_DE_ENTREGA")
    private String lugarDeEntrega;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_FORMA_PAGO", referencedColumnName = "ID_FORMA_PAGO")
    @ManyToOne(optional = false)
    private FormaPago formaPago;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion requisicion;

    public Integer getIdInvitaCotizarRequis() {
        return idInvitaCotizarRequis;
    }

    public void setIdInvitaCotizarRequis(Integer idInvitaCotizarRequis) {
        this.idInvitaCotizarRequis = idInvitaCotizarRequis;
    }

    public Date getFechaInvitacion() {
        return fechaInvitacion;
    }

    public void setFechaInvitacion(Date fechaInvitacion) {
        this.fechaInvitacion = fechaInvitacion;
    }

    public Integer getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public void setTiempoDeEntrega(Integer tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }

    public String getLugarDeEntrega() {
        return lugarDeEntrega;
    }

    public void setLugarDeEntrega(String lugarDeEntrega) {
        this.lugarDeEntrega = lugarDeEntrega;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Requisicion getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
    }

    
}
