package com.modules.sirsr.montoAdjudicacion.application;

import com.modules.sirsr.estatus.application.EstatusDTO;
import java.math.BigDecimal;

public class MontoAdjudicacionDTO {
    private int montoAdjudicacion;
    private String tipoContratacion;
    private BigDecimal importeSuperiorA;
    private BigDecimal importeLimite;
    private EstatusDTO estatus;

    public int getMontoAdjudicacion() {
        return montoAdjudicacion;
    }

    public void setMontoAdjudicacion(int montoAdjudicacion) {
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

    public EstatusDTO getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusDTO estatus) {
        this.estatus = estatus;
    }
}