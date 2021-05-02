package com.modules.sirsr.revision.persistence;

import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.solicitud.persistence.SolicitudMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RevisionMapper {


	public static RevisionDTO toRevisionDTO(Revision revision) {
		if (Objects.isNull(revision)) {
			return null;
		}

		RevisionDTO revisionDTO = new RevisionDTO();
		revisionDTO.setFechaRevision(revision.getRevisionPK().getFechaRevision());
		revisionDTO.setObservacion(revision.getObservacion());
		revisionDTO.setSolicitud(SolicitudMapper.toSolicitudDTO(revision.getSolicitud()));

		return revisionDTO;
	}

	public static List<RevisionDTO> toRevisionsDTOs(List<Revision> revisions) {
		if (Objects.isNull(revisions)) {
			return null;
		}

		List<RevisionDTO> list = new ArrayList<>(revisions.size());
		for (Revision revision : revisions) {
			list.add(toRevisionDTO(revision));
		}

		return list;
	}

	public static Revision toRevision(RevisionDTO revisionDTO) {
		if (Objects.isNull(revisionDTO)) {
			return null;
		}
		Revision revision = new Revision();
		revision.setRevisionPK(new RevisionPK(revisionDTO.getFechaRevision(), revision.getIdSolicitud()));
		revision.setObservacion(revisionDTO.getObservacion());
		revision.setSolicitud(SolicitudMapper.toSolicitud(revisionDTO.getSolicitud()));
		return revision;
	}

}
