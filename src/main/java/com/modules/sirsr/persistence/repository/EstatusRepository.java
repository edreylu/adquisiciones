package com.modules.sirsr.persistence.repository;

import com.modules.sirsr.persistence.entity.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusRepository extends JpaRepository<Estatus,Integer> {
}
