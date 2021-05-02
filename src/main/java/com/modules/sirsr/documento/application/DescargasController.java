package com.modules.sirsr.documento.application;

import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudExcelExporter;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/descargas")
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
		System.out.println(documentoDTO.getMimeType());
		response.setContentType(documentoDTO.getMimeType());
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachment;filename=" + "doc." + documentoDTO.getExtension());
		response.setContentLength((int) documentoDTO.getDocumento().length);
		InputStream is = new ByteArrayInputStream(documentoDTO.getDocumento());
		BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = is.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		outStream.flush();
		is.close();
	}

	@GetMapping("/solicitudes/reporteSolicitud/download/{id}")
	public void exportToExcel(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + currentDateTime + ".xls";
		response.setHeader(headerKey, headerValue);
		SolicitudDTO solicitud = solicitudService.findById(id);
		SolicitudExcelExporter excelExporter = new SolicitudExcelExporter(solicitud);
		excelExporter.export(response);
	}

}
