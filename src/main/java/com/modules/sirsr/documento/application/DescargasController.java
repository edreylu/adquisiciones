package com.modules.sirsr.documento.application;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoExporter;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudExcelExporter;
import com.modules.sirsr.solicitud.domain.SolicitudService;

@Controller
@RequestMapping("/descargas")
public class DescargasController {

	private final DocumentoService documentoService;
	private final SolicitudService solicitudService;

	@Autowired
	public DescargasController(DocumentoService documentoService, SolicitudService solicitudService) {
		this.documentoService = documentoService;
		this.solicitudService = solicitudService;
	}

	@GetMapping("/solicitudes/documentos/download/{id}")
	public void downloadResource(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		DocumentoDTO documentoDTO = documentoService.findById(id);
		DocumentoExporter documentoExporter = new DocumentoExporter(documentoDTO);
		documentoExporter.export(response);
	}

	@GetMapping("/solicitudes/reporteSolicitud/download/{id}")
	public void exportToExcel(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		SolicitudDTO solicitudDTO = solicitudService.findById(id);
		SolicitudExcelExporter excelExporter = new SolicitudExcelExporter(solicitudDTO);
		excelExporter.export(response);
	}

}
