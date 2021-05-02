package com.modules.sirsr.solicitud.domain;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class SolicitudExcelExporter {

	private POIFSFileSystem poiFileSystem;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private SolicitudDTO solicitud;

	public SolicitudExcelExporter(SolicitudDTO solicitud) {
		this.solicitud = solicitud;
	}

	public void Init() throws IOException {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\static\\document\\Requisicion_C-002.xls";
		System.out.printf("" + path);
		poiFileSystem = new POIFSFileSystem(new FileInputStream(path));
		workbook = new HSSFWorkbook(poiFileSystem);
		sheet = workbook.getSheet("REQUIS");
	}

	private void generateHeaderLine() {
		HSSFRow row = sheet.getRow(1);
		if(row==null) row = sheet.createRow(1);
		HSSFCellStyle style = workbook.createCellStyle();
		createCell(row, 4, solicitud.getFechaCreacion().toString(), style);
		
		row = sheet.getRow(5);
		if(row==null) row = sheet.createRow(5);
		createCell(row, 0, solicitud.getUnidadResponsable().getDescripcion(), style);
		createCell(row, 4, solicitud.getActividadOUso().toString(), style);

	}

	private void createCell(HSSFRow row, int columnCount, Object value, HSSFCellStyle style) {
		//sheet.autoSizeColumn(columnCount);
		HSSFCell cell = row.getCell(columnCount);
		if(cell==null) cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
	}

	private void generateDataLines() {
		int rowCount = 8;

		HSSFCellStyle style = workbook.createCellStyle();
		for (RequisicionDTO requisicionDTO : solicitud.getRequisiciones()) {
			HSSFRow row = sheet.getRow(rowCount++);
			if(row==null) row = sheet.createRow(rowCount++);
			for (DetalleRequisicionDTO detalle : requisicionDTO.getDetallesRequisiciones()) {
				createCell(row, 0, detalle.getCantidadSolicitada(), style);
				createCell(row, 1, detalle.getProducto().getUnidadMedida().getNombre(), style);
				createCell(row, 2, detalle.getProducto().getCaracteristicas(), style);
				createCell(row, 4, requisicionDTO.getClavePresupuestaria().getClaveCompleta(), style);
				createCell(row, 13, requisicionDTO.getClavePresupuestaria().getObjetoDeGasto().getObjetoGasto(), style);
				createCell(row, 14, requisicionDTO.getClavePresupuestaria().getAnio(), style);
			}

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		Init();
		generateHeaderLine();
		generateDataLines();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}
