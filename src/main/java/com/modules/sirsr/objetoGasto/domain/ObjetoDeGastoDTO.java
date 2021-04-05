package com.modules.sirsr.objetoGasto.domain;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.partidaGastoGenerica.domain.PartidaGastoGenericaDTO;

import java.util.Date;

public class ObjetoDeGastoDTO {
    private String objetoGasto;
    private String descripcion;
    private String definicion;
    private Date fechaInicio;
    private Date fechaFinal;
    private EstatusDTO estatus;
    private PartidaGastoGenericaDTO claveGenerica;

    public String getObjetoGasto() {
        return objetoGasto;
    }

    public void setObjetoGasto(String objetoGasto) {
        this.objetoGasto = objetoGasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }

    public PartidaGastoGenericaDTO getClaveGenerica() {
        return claveGenerica;
    }

    public void setClaveGenerica(PartidaGastoGenericaDTO claveGenerica) {
        this.claveGenerica = claveGenerica;
    }
}
