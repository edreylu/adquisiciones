/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "VOLANTE")
public class Volante{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_VOLANTE")
    private Integer idVolante;
    @Column(name = "MONTO_SUFICIENCIA")
    private BigDecimal montoSuficiencia;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private short estatus;

    @JoinColumn(name = "ID_CLAVE_PRESUP", referencedColumnName = "ID_CLAVE_PRESUP")
    @ManyToOne(optional = false)
    private ClavePresupuestaria clavePresupuestaria;

    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion requisicion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "volante")
    private List<DetalleRequisicion> detalleRequisiciones;

    public Integer getIdVolante() {
        return idVolante;
    }

    public void setIdVolante(Integer idVolante) {
        this.idVolante = idVolante;
    }

    public BigDecimal getMontoSuficiencia() {
        return montoSuficiencia;
    }

    public void setMontoSuficiencia(BigDecimal montoSuficiencia) {
        this.montoSuficiencia = montoSuficiencia;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public ClavePresupuestaria getClavePresupuestaria() {
        return clavePresupuestaria;
    }

    public void setClavePresupuestaria(ClavePresupuestaria clavePresupuestaria) {
        this.clavePresupuestaria = clavePresupuestaria;
    }

    public Requisicion getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
    }

    public List<DetalleRequisicion> getDetalleRequisiciones() {
        return detalleRequisiciones;
    }

    public void setDetalleRequisiciones(List<DetalleRequisicion> detalleRequisiciones) {
        this.detalleRequisiciones = detalleRequisiciones;
    }
}
