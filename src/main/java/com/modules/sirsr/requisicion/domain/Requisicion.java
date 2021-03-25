/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.domain;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestaria;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.montoAdjudicacion.domain.MontoAdjudicacion;
import com.modules.sirsr.solicitud.domain.Solicitud;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "REQUISICION")
public class Requisicion{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requisicion_generator")
    @SequenceGenerator(name = "requisicion_generator", sequenceName = "ADQUISICIONES.SEQ_REQUISICION", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_REQUISICION")
    private Integer idRequisicion;
    @Column(name = "ID_SOLICITUD", insertable = false, updatable = false)
    private Integer idSolicitud;
    @Column(name = "MONTO_SUFICIENCIA")
    private Double montoSuficiencia;
    @JoinColumn(name = "ID_CLAVE_PRESUP", referencedColumnName = "ID_CLAVE_PRESUP")
    @ManyToOne(optional = false)
    private ClavePresupuestaria clavePresupuestaria;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_MONTO_ADJUDICACION", referencedColumnName = "ID_MONTO_ADJUDICACION")
    @ManyToOne
    private MontoAdjudicacion montoAdjudicacion;
    @JoinColumn(name = "ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD")
    @ManyToOne(optional = false)
    private Solicitud solicitud;
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="requisicion")
    private List<DetalleRequisicion> detallesRequisicion;

    public Integer getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Integer idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Double getMontoSuficiencia() {
        return montoSuficiencia;
    }

    public void setMontoSuficiencia(Double montoSuficiencia) {
        this.montoSuficiencia = montoSuficiencia;
    }

    public ClavePresupuestaria getClavePresupuestaria() {
        return clavePresupuestaria;
    }

    public void setClavePresupuestaria(ClavePresupuestaria clavePresupuestaria) {
        this.clavePresupuestaria = clavePresupuestaria;
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

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public List<DetalleRequisicion> getDetallesRequisicion() {
        return detallesRequisicion;
    }

    public void setDetallesRequisicion(List<DetalleRequisicion> detallesRequisicion) {
        this.detallesRequisicion = detallesRequisicion;
    }
}
