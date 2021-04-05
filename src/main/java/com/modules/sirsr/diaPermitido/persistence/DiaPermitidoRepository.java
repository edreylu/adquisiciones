package com.modules.sirsr.diaPermitido.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaPermitidoRepository extends JpaRepository<DiaPermitido, Date> {

	List<DiaPermitido>  findAllByOrderByDiaPermitidoDesc();
}
