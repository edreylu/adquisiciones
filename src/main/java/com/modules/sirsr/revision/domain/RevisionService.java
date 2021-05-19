/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.revision.domain;

import java.util.List;
import java.util.Optional;

import org.eclipse.persistence.exceptions.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.revision.persistence.Revision;
import com.modules.sirsr.revision.persistence.RevisionMapper;
import com.modules.sirsr.revision.persistence.RevisionPK;
import com.modules.sirsr.revision.persistence.RevisionRepository;

/**
 *
 * @author Edward Reyes
 */
@Service
public class RevisionService {

	private final RevisionRepository revisionRepository;
	private Mensaje msg;

	@Autowired
	public RevisionService(RevisionRepository revisionRepository) {
		this.revisionRepository = revisionRepository;
	}

	public List<RevisionDTO> findAll() {
		return RevisionMapper.toRevisionsDTOs(revisionRepository.findAll());
	}

	public RevisionDTO findById(int id) {
		RevisionPK revisionPK = new RevisionPK();
		Optional<Revision> RevisionOptional = revisionRepository.findById(revisionPK);
		RevisionDTO revisionDTO = RevisionMapper.toRevisionDTO(RevisionOptional.get());
		return revisionDTO;
	}
	
	public List<RevisionDTO> findByIdSolicitud(int id) {
		List<Revision> Revisiones = revisionRepository.findByIdSolicitud(id);
		List<RevisionDTO> revisionDTOs = RevisionMapper.toRevisionsDTOs(Revisiones);
		return revisionDTOs;
	}

	public Mensaje save(RevisionDTO revisionDTO) {
		try {
			revisionRepository.save(RevisionMapper.toRevision(revisionDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (JAXBException e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(RevisionDTO revisionDTO, int id) {
		try {
			RevisionPK revisionPK = new RevisionPK();
			Optional<Revision> prioridadFound = revisionRepository.findById(revisionPK);
			Revision revision = null;//RevisionMapper.setToUpdate(prioridadFound.get(), revisionDTO);
			revisionRepository.save(revision);
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			RevisionPK revisionPK = new RevisionPK();
			revisionRepository.deleteById(revisionPK);
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar por que hay usuarios asociados a rol.");
		}
		return msg;

	}

}
