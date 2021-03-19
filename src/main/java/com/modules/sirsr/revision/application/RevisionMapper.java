package com.modules.sirsr.revision.application;

import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.revision.domain.Revision;
import com.modules.sirsr.solicitud.application.SolicitudMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RevisionMapper {
    
    private ModelMapper modelMapper = new ModelMapper();
    private SolicitudMapper solicitudMapper = new SolicitudMapper();

    public RevisionDTO toRevisionDTO(Revision revision){
        if (Objects.isNull(revision)) {
            return null;
        }

        RevisionDTO revisionDTO = new RevisionDTO();
        revisionDTO.setFechaRevision(revision.getRevisionPK().getFechaRevision());
        revisionDTO.setObservacion(revision.getObservacion());
        revisionDTO.setSolicitud(solicitudMapper.toSolicitudDTO(revision.getSolicitud()));

        return revisionDTO;
    }

    public List<RevisionDTO> toRevisionsDTOs(List<Revision> revisions) {
        if (Objects.isNull(revisions)) {
            return null;
        }

        List<RevisionDTO> list = new ArrayList<>(revisions.size());
        for (Revision revision : revisions) {
            list.add(toRevisionDTO(revision));
        }

        return list;
    }

    public Revision toRevision(RevisionDTO revisionDTO) {
        if (Objects.isNull(revisionDTO)) {
            return null;
        }
        Revision revision = new Revision();
        return revision;
    }

}
