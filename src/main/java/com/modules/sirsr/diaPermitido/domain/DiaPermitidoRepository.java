package com.modules.sirsr.diaPermitido.domain;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaPermitidoRepository extends JpaRepository<DiaPermitido, Date> {
	
}
