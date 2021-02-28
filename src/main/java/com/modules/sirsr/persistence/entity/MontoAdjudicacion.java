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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "MONTO_ADJUDICACION")
public class MontoAdjudicacion{

    @Id
    @Basic(optional = false)
    @Column(name = "MONTO_ADJUDICACION")
    private BigDecimal montoAdjudicacion;
    @Basic(optional = false)
    @Column(name = "TIPO_CONTRATACION")
    private String tipoContratacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IMPORTE_SUPERIOR_A")
    private BigDecimal importeSuperiorA;
    @Column(name = "IMPORTE_LIMITE")
    private BigDecimal importeLimite;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "montoAdjudicacion")
    private List<Requisicion> requisicionList;


    public BigDecimal getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(BigDecimal montoAdjudicacion) {
        this.montoAdjudicacion = montoAdjudicacion;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public BigDecimal getImporteSuperiorA() {
        return importeSuperiorA;
    }

    public void setImporteSuperiorA(BigDecimal importeSuperiorA) {
        this.importeSuperiorA = importeSuperiorA;
    }

    public BigDecimal getImporteLimite() {
        return importeLimite;
    }

    public void setImporteLimite(BigDecimal importeLimite) {
        this.importeLimite = importeLimite;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public List<Requisicion> getRequisicionList() {
        return requisicionList;
    }

    public void setRequisicionList(List<Requisicion> requisicionList) {
        this.requisicionList = requisicionList;
    }

    
}
