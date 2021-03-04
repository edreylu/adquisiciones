/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.volante;

import com.modules.sirsr.clavePresupuestaria.ClavePresupuestariaDTO;
import com.modules.sirsr.requisicion.RequisicionDTO;

import java.math.BigDecimal;

/**
 *
 * @author Edward Reyes
 */
public class VolanteDTO {
    private int idVolante;
    private BigDecimal montoSuficiencia;
    private int estatus;
    private ClavePresupuestariaDTO clavePresupuestaria;
    private RequisicionDTO requisicion;

    public int getIdVolante() {
        return idVolante;
    }

    public void setIdVolante(int idVolante) {
        this.idVolante = idVolante;
    }

    public BigDecimal getMontoSuficiencia() {
        return montoSuficiencia;
    }

    public void setMontoSuficiencia(BigDecimal montoSuficiencia) {
        this.montoSuficiencia = montoSuficiencia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public ClavePresupuestariaDTO getClavePresupuestaria() {
        return clavePresupuestaria;
    }

    public void setClavePresupuestaria(ClavePresupuestariaDTO clavePresupuestaria) {
        this.clavePresupuestaria = clavePresupuestaria;
    }

    public RequisicionDTO getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(RequisicionDTO requisicion) {
        this.requisicion = requisicion;
    }
}
