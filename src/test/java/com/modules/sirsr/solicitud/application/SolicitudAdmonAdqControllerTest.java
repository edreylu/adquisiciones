package com.modules.sirsr.solicitud.application;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.modules.sirsr.capitulo.domain.CapituloDTO;
import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.concepto.domain.ConceptoDTO;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.datosPersonales.domain.DatosPersonalesDTO;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.marca.domain.MarcaDTO;
import com.modules.sirsr.montoAdjudicacion.domain.MontoAdjudicacionDTO;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoDTO;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoService;
import com.modules.sirsr.partidaGastoGenerica.domain.PartidaGastoGenericaDTO;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.producto.domain.ProductoDTO;
import com.modules.sirsr.producto.domain.ProductoService;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionService;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;
import com.modules.sirsr.requisicion.domain.RequisicionService;
import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.revision.domain.RevisionService;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.tipoProducto.domain.TipoProductoDTO;
import com.modules.sirsr.unidadMedida.domain.UnidadMedidaDTO;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;
import com.modules.sirsr.usuario.domain.UserDetailsServiceImpl;
import com.modules.sirsr.usuario.domain.UsuarioService;

@WebMvcTest(SolicitudAdmonAdqController.class)
public class SolicitudAdmonAdqControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private SolicitudService solicitudService;
	@MockBean
	private ObjetoDeGastoService objetoDeGastoService;
	@MockBean
	private RequisicionService requisicionService;
	@MockBean
	private DetalleRequisicionService detalleRequisicionService;
	@MockBean
	private DocumentoService documentoService;
	@MockBean
	private TipoDocumentoService tipoDocumentoService;
	@MockBean
	private UsuarioService usuarioService;
	@MockBean
	private RevisionService revisionService;
	@MockBean
	private ProductoService productoService;
	@MockBean
	private UserDetailsServiceImpl userDetailsService;
	
	private EstatusDTO estatus;
	private UnidadResponsableDTO unidadResponsable;
	private PrioridadDTO prioridad;
	private TipoDocumentoDTO tipoDocumento;
	private SolicitudDTO solicitud;
	private RevisionDTO revision;
	private MockMultipartFile file;
	private DocumentoDTO documento;
	private ClavePresupuestariaDTO clavePresupuestaria;
	private RequisicionDTO requisicion;
	private MarcaDTO marca;
	private ProductoDTO producto;
	private MontoAdjudicacionDTO montoAdjudicacion;
	private UnidadMedidaDTO unidadMedida;
	private TipoProductoDTO tipoProducto;
	private ObjetoDeGastoDTO objetoGasto;
	private PartidaGastoGenericaDTO claveGenerica;
	private ConceptoDTO concepto;
	private CapituloDTO capitulo;
	private Date date;
	
	@BeforeEach
	protected void setUp() throws Exception {
		
		date = Date.from(Instant.now());
		estatus = new EstatusDTO(1, "ACT", "ACTIVO", "red", "Activo");
		unidadResponsable = new UnidadResponsableDTO("21", "prueba", date, date, estatus);
		prioridad = new PrioridadDTO(1, "main", estatus);
		tipoDocumento = new TipoDocumentoDTO(1, "unico", "S", "S", estatus);
		file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
		documento = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		documento.setFile(file);
		clavePresupuestaria = new ClavePresupuestariaDTO(1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", null, unidadResponsable);
		solicitud = new SolicitudDTO(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable);
		solicitud.setIdSolicitud(1);
		revision = new RevisionDTO(date, "esta mal", solicitud);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	public void itShouldListAllSolicitudesAdmonAdq() throws Exception {
		
		// given
		List<SolicitudDTO> solicitudes = new ArrayList<>();
		solicitudes.add(new SolicitudDTO(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable));
		solicitudes.add(new SolicitudDTO(date, 2021, 12, "otro", estatus, prioridad, unidadResponsable));

		// when
		when(solicitudService.findAllEmitidas()).thenReturn(solicitudes);
		when(productoService.areThereProductsSuggestions()).thenReturn(true);

		// then
		this.mockMvc
				.perform(get("/admonadq/solicitudes").with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMONADQ")))
				// .andDo(print())
				.andExpect(status().isOk()).andExpect(view().name("admonadq/solicitudes/principal"))
				.andExpect(model().attribute("areThereProductsSuggestions", true))
				.andExpect(model().attribute("lista", Matchers.is(solicitudes)))
				.andExpect(model().attribute("lista", Matchers.hasSize(2)));
	}

	@Test
	public void itShouldShowsDetailsSolicitudAdmonAdq() throws Exception {

		// given
		List<RequisicionDTO> requisiciones = new ArrayList<>();
		requisiciones.add(new RequisicionDTO(1, 1000.10, clavePresupuestaria, estatus, null, solicitud, null));
		requisiciones.add(new RequisicionDTO(2, 4000.10, clavePresupuestaria, estatus, null, solicitud, null));

		List<DocumentoDTO> documentos = new ArrayList<>();
		TipoDocumentoDTO tipoDocumento2 = new TipoDocumentoDTO(2, "no unico", "N", "N", estatus);
		documentos.add(new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento));
		documentos.add(new DocumentoDTO(2, null, "JPG", "JPG", solicitud, tipoDocumento2));
		documentos.add(new DocumentoDTO(3, null, "JPG", "JPG", solicitud, tipoDocumento2));

		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);
		when(requisicionService.findByIdSolicitud(Mockito.anyInt())).thenReturn(requisiciones);
		when(documentoService.findByIdSolicitud(Mockito.anyInt())).thenReturn(documentos);

		// then
		this.mockMvc
				.perform(get("/admonadq/solicitudes/revisar/{id}", solicitud.getIdSolicitud()).with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMONADQ")))
				// .andDo(print())
				.andExpect(model().attribute("solicitud", Matchers.is(solicitud)))
				.andExpect(model().attribute("requisiciones", Matchers.is(requisiciones)))
				.andExpect(model().attribute("documentos", Matchers.is(documentos)))
				.andExpect(view().name("admonadq/solicitudes/revisar"));
	}

	@Test
	public void canAcceptSolicitudById() throws Exception {

		// given
		Mensaje msg = Mensaje.success("");

		// when
		when(solicitudService.acceptById(Mockito.anyInt())).thenReturn(msg);

		// then
		this.mockMvc
				.perform(post("/admonadq/solicitudes/aceptar/{id}", solicitud.getIdSolicitud())
						.with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMONADQ")))
				// .andDo(print())
				.andExpect(flash().attribute("clase", "success"))
				.andExpect(view().name("redirect:/admonadq/solicitudes"))
				.andExpect(status().isFound())
				.andExpect(header().string("Location", "/admonadq/solicitudes"));
	}

	@Test
	public void canRequestCorreccionEdit() throws Exception {
		
		//given
		
		// when
		when(solicitudService.findById(Mockito.anyInt())).thenReturn(solicitud);

		// then
		this.mockMvc
				.perform(get("/admonadq/solicitudes/correccion/{id}", solicitud.getIdSolicitud()).with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMONADQ")))
				// .andDo(print())
				.andExpect(model().attribute("solicitud", Matchers.is(solicitud)))
				.andExpect(view().name("admonadq/solicitudes/correccion"));
	}

	@Test
	public void canSendCorreccion() throws Exception {

		// given
		Mensaje msg = Mensaje.success("");

		// when
		when(solicitudService.correction(Mockito.any(),Mockito.anyInt())).thenReturn(msg);

		// then
		this.mockMvc
				.perform(post("/admonadq/solicitudes/correccion/add/{id}", solicitud.getIdSolicitud())
						.content(objectMapper.writeValueAsString(revision))
						.contentType(MediaType.APPLICATION_JSON)
						.with(csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMONADQ")))
				// .andDo(print())
				.andExpect(flash().attribute("clase", "success"))
				.andExpect(view().name("redirect:/admonadq/solicitudes"))
				.andExpect(status().isFound())
				.andExpect(header().string("Location", "/admonadq/solicitudes"));
	}
	
	@Test
	void itShouldReturnsDetallesRequisicionAdmonAdq() throws Exception {

		// given
		montoAdjudicacion = new MontoAdjudicacionDTO(1, "", 1000.00, 100.00, estatus);
		unidadMedida = new UnidadMedidaDTO(1, "21", "ALGUNO", "ALGO", estatus);
		capitulo = new CapituloDTO(1, "", "", date, date, estatus);
		concepto = new ConceptoDTO(1, "", "", date, date, capitulo, estatus);
		claveGenerica = new PartidaGastoGenericaDTO(1, "", "", date, date, concepto, estatus);
		objetoGasto = new ObjetoDeGastoDTO("1", "", "", date, date, estatus, claveGenerica);
		tipoProducto = new TipoProductoDTO(1, "", objetoGasto, estatus);
		producto = new ProductoDTO(1, "", 1000.00, date, 1, unidadMedida, tipoProducto, estatus);

		List<DetalleRequisicionDTO> detallesRequisicion = new ArrayList<>();
		detallesRequisicion.add(new DetalleRequisicionDTO(1, 1, 120.12, requisicion, marca, producto));
		detallesRequisicion.add(new DetalleRequisicionDTO(2, 1, 345.12, requisicion, marca, producto));

		requisicion = new RequisicionDTO(1, 2000.00, clavePresupuestaria, estatus, montoAdjudicacion, solicitud,
				detallesRequisicion);

		// when
		when(detalleRequisicionService.findByIdRequisicion(Mockito.anyInt())).thenReturn(detallesRequisicion);

		// then
		this.mockMvc
				.perform(get("/admonadq/solicitudes/searchDetallesRequisicion/{id}", requisicion.getIdRequisicion())
						.with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("ADMIN").roles("ADMIN", "ADMONADQ")))
				// .andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("admonadq/solicitudes/revisar :: modalDetalles"))
				.andExpect(model().attribute("detallesRequisicion", Matchers.is(detallesRequisicion)))
				.andExpect(model().attribute("detallesRequisicion", Matchers.hasSize(2)));
	}

}
