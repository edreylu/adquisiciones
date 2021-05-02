package com.modules.sirsr.revision.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RevisionRepository extends JpaRepository<Revision, RevisionPK> {
	List<Revision> findByIdSolicitud(Integer idSolicitud);
}
