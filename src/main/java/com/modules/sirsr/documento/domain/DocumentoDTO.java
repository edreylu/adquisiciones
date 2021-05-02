/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;

/**
 *
 * @author Edward Reyes
 */
public class DocumentoDTO implements Serializable {
	
	private Integer idDocumento;
	private byte[] documento;
	private Date fechaActualizacion;
	private SolicitudDTO solicitud;
	private TipoDocumentoDTO tipoDocumento;
	private String mimeType;
	private String extension;
	private MultipartFile file;
	
	public DocumentoDTO() {

	}
	
	public DocumentoDTO(Integer idDocumento, byte[] documento, String mimeType, String extension, SolicitudDTO solicitud,
			TipoDocumentoDTO tipoDocumento) {
		this.idDocumento = idDocumento;
		this.documento = documento;
		this.mimeType = mimeType;
		this.extension = extension;
		this.solicitud = solicitud;
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public SolicitudDTO getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudDTO solicitud) {
		this.solicitud = solicitud;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
}
