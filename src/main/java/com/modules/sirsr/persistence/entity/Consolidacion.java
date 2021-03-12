/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "CONSOLIDACION")
public class Consolidacion{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONSOLIDACION")
    private Integer idConsolidacion;
    @Basic(optional = false)
    @Column(name = "ANIO_CALENDARIZACION")
    private Integer anioCalendarizacion;
    @Basic(optional = false)
    @Column(name = "MES_CALENDARIZACION")
    private Integer mesCalendarizacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CONSOLIDACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConsolidacion;
    @Column(name = "MONTO_SUFICIENCIA")
    private BigDecimal montoSuficiencia;
    @JoinTable(name = "CONSOLIDA_REQUISICION", joinColumns = {
        @JoinColumn(name = "ID_CONSOLIDACION", referencedColumnName = "ID_CONSOLIDACION")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")})
    @ManyToMany
    private List<Requisicion> requisiciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consolidacion")
    private List<DetalleConsolidacion> detallesConsolidacion;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_MONTO_ADJUDICACION", referencedColumnName = "ID_MONTO_ADJUDICACION")
    @ManyToOne
    private MontoAdjudicacion montoAdjudicacion;
    @JoinColumn(name = "OBJETO_GASTO", referencedColumnName = "OBJETO_GASTO")
    @ManyToOne(optional = false)
    private ObjetoDeGasto objetoGasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consolidacion")
    private List<CotizaConsolidacion> cotizaConsolidaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consolidacion")
    private List<InvitacionACotizarConsolida> invitacionesCotizarConsolida;

    public Integer getIdConsolidacion() {
        return idConsolidacion;
    }

    public void setIdConsolidacion(Integer idConsolidacion) {
        this.idConsolidacion = idConsolidacion;
    }

    public Integer getAnioCalendarizacion() {
        return anioCalendarizacion;
    }

    public void setAnioCalendarizacion(Integer anioCalendarizacion) {
        this.anioCalendarizacion = anioCalendarizacion;
    }

    public Integer getMesCalendarizacion() {
        return mesCalendarizacion;
    }

    public void setMesCalendarizacion(Integer mesCalendarizacion) {
        this.mesCalendarizacion = mesCalendarizacion;
    }

    public Date getFechaConsolidacion() {
        return fechaConsolidacion;
    }

    public void setFechaConsolidacion(Date fechaConsolidacion) {
        this.fechaConsolidacion = fechaConsolidacion;
    }

    public BigDecimal getMontoSuficiencia() {
        return montoSuficiencia;
    }

    public void setMontoSuficiencia(BigDecimal montoSuficiencia) {
        this.montoSuficiencia = montoSuficiencia;
    }

    public List<Requisicion> getRequisiciones() {
        return requisiciones;
    }

    public void setRequisiciones(List<Requisicion> requisiciones) {
        this.requisiciones = requisiciones;
    }

    public List<DetalleConsolidacion> getDetallesConsolidacion() {
        return detallesConsolidacion;
    }

    public void setDetallesConsolidacion(List<DetalleConsolidacion> detallesConsolidacion) {
        this.detallesConsolidacion = detallesConsolidacion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public MontoAdjudicacion getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(MontoAdjudicacion montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public ObjetoDeGasto getObjetoGasto() {
        return objetoGasto;
    }

    public void setObjetoGasto(ObjetoDeGasto objetoGasto) {
        this.objetoGasto = objetoGasto;
    }

    public List<CotizaConsolidacion> getCotizaConsolidaciones() {
        return cotizaConsolidaciones;
    }

    public void setCotizaConsolidaciones(List<CotizaConsolidacion> cotizaConsolidaciones) {
        this.cotizaConsolidaciones = cotizaConsolidaciones;
    }

    public List<InvitacionACotizarConsolida> getInvitacionesCotizarConsolida() {
        return invitacionesCotizarConsolida;
    }

    public void setInvitacionesCotizarConsolida(List<InvitacionACotizarConsolida> invitacionesCotizarConsolida) {
        this.invitacionesCotizarConsolida = invitacionesCotizarConsolida;
    }
    
    
    
}
