package com.modules.sirsr.clavePresupuestaria.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClavePresupuestariaRepository extends JpaRepository<ClavePresupuestaria, Integer> {
    List<ClavePresupuestaria> findByUnidadResp(String unidadResp);
    List<ClavePresupuestaria> findAllByIdEstatus(Integer idEstatus);
}
