package com.modules.sirsr.documento.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;
import com.modules.sirsr.usuario.domain.UserDetailsServiceImpl;

@WebMvcTest(DocumentoController.class)
public class DocumentoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private UserDetailsServiceImpl userDetailsService;

	@MockBean
	private DocumentoService documentoService;

	@MockBean
	private SolicitudService solicitudService;

	@MockBean
	private TipoDocumentoService tipoDocumentoService;

	private EstatusDTO estatus;
	private UnidadResponsableDTO unidadResponsable;
	private PrioridadDTO prioridad;
	private TipoDocumentoDTO tipoDocumento;
	private SolicitudDTO solicitud;
	private MockMultipartFile file;
	private DocumentoDTO documento;

	@BeforeEach
	protected void setUp() throws Exception {
		Date date = Date.from(Instant.now());
		estatus = new EstatusDTO(1, "ACT", "ACTIVO", "red", "Activo");
		unidadResponsable = new UnidadResponsableDTO("21", "prueba", date, date, estatus);
		prioridad = new PrioridadDTO(1, "main", estatus);
		tipoDocumento = new TipoDocumentoDTO(1, "unico", "S", "S", estatus);
		solicitud = new SolicitudDTO(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable);
		solicitud.setIdSolicitud(1);
		file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	void itShouldFindTwoDocumentos() throws Exception {

		// given
		List<DocumentoDTO> documentos = new ArrayList<>();
		documentos.add(new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento));
		documentos.add(new DocumentoDTO(2, null, "JPG", "JPG", solicitud, tipoDocumento));

		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);
		when(documentoService.findByIdSolicitud(Mockito.anyInt())).thenReturn(documentos);

		// then
		this.mockMvc
				.perform(get("/usuario/solicitudes/documentos/{id}", solicitud.getIdSolicitud()).with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "USER")))
				// .andDo(print())
				.andExpect(status().isOk()).andExpect(view().name("usuario/solicitudes/documentos/principal"))
				.andExpect(model().attribute("solicitud", Matchers.is(solicitud)))
				.andExpect(model().attribute("documentos", Matchers.is(documentos)))
				.andExpect(model().attribute("documentos", Matchers.hasSize(2)));
	}

	@Test
	void itShouldNotFindAnyDocument() throws Exception {

		// given
		List<DocumentoDTO> documentos = new ArrayList<>();
		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);
		when(documentoService.findByIdSolicitud(Mockito.anyInt())).thenReturn(documentos);

		// then
		this.mockMvc
				.perform(get("/usuario/solicitudes/documentos/{id}", solicitud.getIdSolicitud()).with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "USER")))
				// .andDo(print())
				.andExpect(status().isOk()).andExpect(view().name("usuario/solicitudes/documentos/principal"))
				.andExpect(model().attribute("solicitud", Matchers.is(solicitud)))
				.andExpect(model().attribute("documentos", Matchers.is(documentos)))
				.andExpect(model().attribute("documentos", Matchers.hasSize(0)));
	}

	@Test
	void canSaveDocumento() throws Exception {

		// given
		Mensaje msg = Mensaje.success("Documentos agregados correctamente");
		documento = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);

		// when
		when(documentoService.save(Mockito.any())).thenReturn(msg);
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);

		// then
		this.mockMvc
				.perform(multipart("/usuario/solicitudes/documentos/update/{id}", solicitud.getIdSolicitud()).file(file)
						.content(objectMapper.writeValueAsString(documento)).contentType(MediaType.APPLICATION_JSON)
						.with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "USER")))
				// .andDo(print())
				.andExpect(flash().attribute("clase", "success"))
				.andExpect(view().name("redirect:/usuario/solicitudes/documentos/" + solicitud.getIdSolicitud()))
				.andExpect(status().isFound())
				.andExpect(header().string("Location", "/usuario/solicitudes/documentos/" + solicitud.getIdSolicitud()));
	}

	@Test
	void canNotSaveDocumentoWithoutFile() throws Exception {

		// given
		Mensaje msg = Mensaje.danger("");
		file = new MockMultipartFile("file2", "", "", "".getBytes());
		documento = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);

		// when
		when(documentoService.save(Mockito.any())).thenReturn(msg);
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);

		// then
		this.mockMvc
				.perform(multipart("/usuario/solicitudes/documentos/update/{id}", solicitud.getIdSolicitud()).file(file)
						.content(objectMapper.writeValueAsString(documento)).contentType(MediaType.APPLICATION_JSON)
						.with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "USER")))
				// .andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect((res) -> assertTrue(res.getResolvedException().getClass() != null));
	}

	@Test
	void canDeleteDocumento() throws Exception {

		// given
		Mensaje msg = Mensaje.success("Eliminado correctamente");

		// when
		when(documentoService.deleteById(Mockito.anyInt())).thenReturn(msg);

		// then
		this.mockMvc
				.perform(get("/usuario/solicitudes/documentos/eliminar/{id}/{idReq}", 1, solicitud.getIdSolicitud())
						.with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "USER")))
				// .andDo(print())
				.andExpect(flash().attribute("clase", "success"))
				.andExpect(status().isFound())
				.andExpect(header().string("Location", "/usuario/solicitudes/documentos/" + solicitud.getIdSolicitud()));
	}

	@Test
	void itShouldAddDocumentoAndReturnsValues() throws Exception {

		// given
		List<Integer> tiposDocumentoNot = new ArrayList<>();
		tiposDocumentoNot.add(1);

		List<TipoDocumentoDTO> tiposDocumento = new ArrayList<>();
		// tiposDocumento.add(new TipoDocumentoDTO(1, "eje","S","S", estatus));
		tiposDocumento.add(new TipoDocumentoDTO(2, "eje2", "N", "N", estatus));
		tiposDocumento.add(new TipoDocumentoDTO(3, "eje3", "N", "N", estatus));

		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);
		when(documentoService.getTiposDocumentoNot(Mockito.anyInt())).thenReturn(tiposDocumentoNot);
		when(tipoDocumentoService.findAllByTiposDocumentoNot(tiposDocumentoNot)).thenReturn(tiposDocumento);

		// then
		this.mockMvc
				.perform(get("/usuario/solicitudes/documentos/addDocumento/{id}", solicitud.getIdSolicitud())
						.with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "USER")))
				// .andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("usuario/solicitudes/documentos/principal :: modalSubirDocumento"))
				.andExpect(model().attribute("tiposDocumento", Matchers.is(tiposDocumento)))
				.andExpect(model().attribute("tiposDocumento", Matchers.hasSize(2)))
				.andExpect(model().attribute("solicitud", Matchers.is(solicitud)));
	}

}
