package com.modules.sirsr.documento.domain;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;

public class DocumentoExporter {
	
	private final DocumentoDTO documento;
	
	public DocumentoExporter(DocumentoDTO documento) {
		this.documento = documento;
	}
	
	public void export(HttpServletResponse response) throws IOException {
		System.out.println(documento.getMimeType());
		response.setContentType(documento.getMimeType());
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachment;filename=" + "doc." + documento.getExtension());
		response.setContentLength((int) documento.getDocumento().length);
		BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());
		InputStream is = new ByteArrayInputStream(documento.getDocumento());
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = is.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		outStream.flush();
		is.close();
	}
	
}
