package com.modules.sirsr.folioRequisicion.domain;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FolioRequisicionRepository extends JpaRepository<FolioRequisicion, Integer> {
	
	@Transactional
	@Modifying
	@Query("update FolioRequisicion fr set fr.estatus.idEstatus =:estatusI where fr.estatus.idEstatus =:estatusA")	
	public void inactiveAll(Integer estatusI, Integer estatusA);
	
	
}
