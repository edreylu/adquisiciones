package com.modules.sirsr.documento.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.documento.persistence.Documento;
import com.modules.sirsr.documento.persistence.DocumentoMapper;
import com.modules.sirsr.documento.persistence.DocumentoRepository;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;

@ExtendWith(MockitoExtension.class)
class DocumentoServiceTest {

	@Autowired
	private DocumentoService underTest;
	@Mock
	private DocumentoRepository documentoRepository;
	@Mock
	private SolicitudService solicitudService;
	@Mock
	private TipoDocumentoService tipoDocumentoService;

	private EstatusDTO estatus;
	private UnidadResponsableDTO unidadResponsable;
	private PrioridadDTO prioridad;
	private TipoDocumentoDTO tipoDocumento;
	private SolicitudDTO solicitud;
	private MockMultipartFile file;
	private DocumentoDTO documento;
	private Date date;

	@BeforeEach
	void setUp() throws Exception {
		underTest = new DocumentoService(documentoRepository, solicitudService, tipoDocumentoService);

		date = Date.from(Instant.now());
		estatus = new EstatusDTO(1, "ACT", "ACTIVO", "red", "Activo");
		unidadResponsable = new UnidadResponsableDTO("21", "prueba", date, date, estatus);
		prioridad = new PrioridadDTO(1, "main", estatus);
		tipoDocumento = new TipoDocumentoDTO(1, "unico","S","S", estatus);
		solicitud = new SolicitudDTO(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable);
		file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
		documento = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		documento.setFile(file);
	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void itShouldFindAllDocumentos() {
		underTest.findAll();
		verify(documentoRepository).findAll();
	}

	@Test
	void itShouldFindDocumentosById() throws Exception {

		// given
		int value = 1;
		Optional<Documento> documentoOp = Optional.of(DocumentoMapper.toDocumento(documento));

		// when
		when(documentoRepository.findById(Mockito.anyInt())).thenReturn(documentoOp);
		DocumentoDTO expectedDocument = underTest.findById(value);

		// then
		assertThat(expectedDocument.getIdDocumento()).isEqualTo(value);
	}
	
	@Test
	void itShouldNotFindDocumentosById() throws Exception {

		// given
		int valueToFind = 1;
		int ValueExpected = 2;
		Optional<Documento> documentoOp = Optional.of(DocumentoMapper.toDocumento(documento));

		// when
		when(documentoRepository.findById(Mockito.anyInt())).thenReturn(documentoOp);
		DocumentoDTO expectedDocument = underTest.findById(valueToFind);

		// then
		assertThat(expectedDocument.getIdDocumento()).isNotEqualTo(ValueExpected);
	}


	@Test
	void canAddDocumento() throws Exception {
		// given

		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);
		when(tipoDocumentoService.findById(Mockito.anyInt())).thenReturn(tipoDocumento);
		Mensaje mensaje = underTest.save(documento);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);

	}
	
	@Test
	void canNotAddDocumentoBecauseFileIsNull() throws Exception {
		// given
		documento = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		documento.setFile(null);

		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);
		when(tipoDocumentoService.findById(Mockito.anyInt())).thenReturn(tipoDocumento);
		Mensaje mensaje = underTest.save(documento);

		// then
		assertThat(mensaje.getResult()).isEqualTo(2);

	}
	
	@Test
	void canDeleteDocumentoById() throws Exception {
		// given

		// when
		Mensaje mensaje = underTest.deleteById(Mockito.anyInt());

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);

	}
	
	@Test
	void itShouldFindTiposDocumentosNot() throws Exception {
		// given
		List<Integer> idTiposDocumentosUnicos = Arrays.asList(1);
		TipoDocumentoDTO tipoDocumento2 = new TipoDocumentoDTO(2, "no unico","N","N", estatus);
		DocumentoDTO documento1 = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		DocumentoDTO documento2 = new DocumentoDTO(2, null, "JPG", "JPG", solicitud, tipoDocumento2);
		DocumentoDTO documento3 = new DocumentoDTO(3, null, "JPG", "JPG", solicitud, tipoDocumento2);
		documento1.setFile(file);
		documento2.setFile(file);
		documento3.setFile(file);
		List<Documento> documentos = Arrays.asList(DocumentoMapper.toDocumento(documento1),DocumentoMapper.toDocumento(documento2),DocumentoMapper.toDocumento(documento3));

		// when
		when(documentoRepository.findByIdSolicitud(Mockito.anyInt())).thenReturn(documentos);
		when(tipoDocumentoService.findAllIdDocumentosUnicos()).thenReturn(idTiposDocumentosUnicos);
		List<Integer> idTiposDocumentos = underTest.getTiposDocumentoNot(1);

		// then
		assertThat(idTiposDocumentos.get(0)).isEqualTo(1);

	}

}
