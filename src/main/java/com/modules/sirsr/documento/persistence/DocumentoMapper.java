package com.modules.sirsr.documento.persistence;

import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.solicitud.persistence.SolicitudMapper;
import com.modules.sirsr.tipoDocumento.persistence.TipoDocumentoMapper;
import java.io.IOException;
import java.time.Instant;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DocumentoMapper {

	public static DocumentoDTO toDocumentoDTO(Documento documento) {

		DocumentoDTO documentoDTO = new DocumentoDTO();
		documentoDTO.setIdDocumento(documento.getIdDocumento());
		documentoDTO.setDocumento(documento.getDocumento());
		documentoDTO.setSolicitud(SolicitudMapper.toSolicitudDTO(documento.getSolicitud()));
		documentoDTO.setTipoDocumento(TipoDocumentoMapper.toTipoDocumentoDTO(documento.getTipoDocumento()));
		documentoDTO.setFechaActualizacion(documento.getFechaActualizacion());
		documentoDTO.setMimeType(documento.getMimeType());
		documentoDTO.setExtension(documento.getExtension());
		return documentoDTO;
	}

	public static Documento toDocumento(DocumentoDTO documentoDTO) {

		if (Objects.isNull(documentoDTO)) {
			return null;
		}

		Documento documento = new Documento();
		documento.setIdDocumento(documentoDTO.getIdDocumento());
		try {
			documento.setDocumento(documentoDTO.getFile().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		documento.setFechaActualizacion(Date.from(Instant.now()));
		documento.setSolicitud(SolicitudMapper.toSolicitud(documentoDTO.getSolicitud()));
		documento.setTipoDocumento(TipoDocumentoMapper.toTipoDocumento(documentoDTO.getTipoDocumento()));
		documento.setMimeType(documentoDTO.getFile().getContentType());
		documento.setExtension(FilenameUtils.getExtension(documentoDTO.getFile().getOriginalFilename()));
		System.out.println(documento.toString());
		return documento;

	}

	public static List<DocumentoDTO> toDocumentoDTOs(List<Documento> documentos) {
		if (Objects.isNull(documentos)) {
			return null;
		}
		List<DocumentoDTO> list = new ArrayList<>(documentos.size());
		for (Documento documento : documentos) {
			list.add(toDocumentoDTO(documento));
		}
		return list;
	}

	public static List<Documento> toDocumentos(List<DocumentoDTO> documentoDTOs) {
		if (Objects.isNull(documentoDTOs)) {
			return null;
		}
		List<Documento> list = new ArrayList<>(documentoDTOs.size());
		for (DocumentoDTO documento : documentoDTOs) {
			list.add(toDocumento(documento));
		}
		return list;
	}

}
