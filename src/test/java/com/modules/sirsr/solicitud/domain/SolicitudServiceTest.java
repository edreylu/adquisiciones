package com.modules.sirsr.solicitud.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
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
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.datosPersonales.domain.DatosPersonalesDTO;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.persistence.Documento;
import com.modules.sirsr.documento.persistence.DocumentoMapper;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.prioridad.domain.PrioridadDTO;
import com.modules.sirsr.prioridad.domain.PrioridadService;
import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.revision.domain.RevisionService;
import com.modules.sirsr.solicitud.persistence.Solicitud;
import com.modules.sirsr.solicitud.persistence.SolicitudMapper;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class SolicitudServiceTest {
	
	@Autowired
	private SolicitudService underTest;
	@Mock
	private SolicitudRepository solicitudRepository;
	@Mock
	private UsuarioService usuarioService;
	@Mock
	private EstatusService estatusService;
	@Mock
	private TipoDocumentoService tipoDocumentoService;
	@Mock
	private PrioridadService prioridadService;
	@Mock
	private RevisionService revisionService;
	
	private EstatusDTO estatus;
	private UsuarioDTO usuario;
	private DatosPersonalesDTO datosPersonales;
	private UnidadResponsableDTO unidadResponsable;
	private PrioridadDTO prioridad;
	private SolicitudDTO solicitud;
	private MockMultipartFile file;
	private TipoDocumentoDTO tipoDocumento;
	private DocumentoDTO documento;
	private Date date;

	@BeforeEach
	protected void setUp() throws Exception {
		underTest = new SolicitudService(solicitudRepository, usuarioService, estatusService, tipoDocumentoService, prioridadService, revisionService);
		
		date = Date.from(Instant.now());
		estatus = new EstatusDTO(1, "ACT", "ACTIVO", "red", "Activo");
		unidadResponsable = new UnidadResponsableDTO("21", "prueba", date, date, estatus);
		datosPersonales = new DatosPersonalesDTO(80538, "REYES", "LUGO", "EDWARD", "edreylu10@gmail.com", "2222222222", "2222222222");
		usuario = new UsuarioDTO(1,"ADMIN",date,estatus,1,datosPersonales,unidadResponsable);
		prioridad = new PrioridadDTO(1, "main", estatus);
		solicitud = new SolicitudDTO(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable);
		solicitud.setIdSolicitud(1);

		file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
		tipoDocumento = new TipoDocumentoDTO(1, "unico","S","S", estatus);
		documento = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		documento.setFile(file);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}
	

	@Test
	public void itShouldFindAll() throws Exception {
		underTest.findAll();
		verify(solicitudRepository).findAll(Sort.by(Sort.Direction.DESC, "idSolicitud"));
	}

	@Test
	public void itShouldFindAllEmitidas() throws Exception {
		underTest.findAllEmitidas();
		verify(solicitudRepository).findByIdEstatusGreaterThanEqual(11);
	}

	@Test
	public void itShoudFindByClaveUnidad() throws Exception {
		createUserDetails();
        when(usuarioService.findByUserName(Mockito.anyString())).thenReturn(usuario);
		underTest.findByClaveUnidad();
		verify(solicitudRepository).findByClaveUr("21", Sort.by(Sort.Direction.DESC, "idSolicitud"));
	}

	@Test
	public void itShouldFindById() throws Exception {
		
		// given
		int valueToFind = 1;
		int valueExpected = 1;
		Optional<Solicitud> solicitudOp = Optional.of(SolicitudMapper.toSolicitud(solicitud));

		// when
		when(solicitudRepository.findById(Mockito.anyInt())).thenReturn(solicitudOp);
		SolicitudDTO expectedSolicitud = underTest.findById(valueToFind);

		// then
		assertThat(expectedSolicitud.getIdSolicitud()).isEqualTo(valueExpected);
	}

	@Test
	public void canSave() throws Exception {
		
		// given

		// when
		when(usuarioService.findByUserName(Mockito.anyString())).thenReturn(usuario);
		when(estatusService.findById(Mockito.anyInt())).thenReturn(estatus);
		when(prioridadService.findById(Mockito.anyInt())).thenReturn(prioridad);
		Mensaje mensaje = underTest.save(solicitud);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);
	}

	@Test
	public void canUpdate() throws Exception {
		
		// given
		SolicitudDTO solicitudUpdated = new SolicitudDTO(date, 2021, 10, "otro", estatus, prioridad, unidadResponsable);
		Optional<Solicitud> solicitudOp = Optional.of(SolicitudMapper.toSolicitud(solicitud));
		
		// when
		when(solicitudRepository.findById(Mockito.anyInt())).thenReturn(solicitudOp);
		Mensaje mensaje = underTest.update(solicitudUpdated, 1);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);
	}

	@Test
	public void canDeleteById() throws Exception {
		
		// given
		Optional<Solicitud> solicitudOp = Optional.of(SolicitudMapper.toSolicitud(solicitud));
		estatus = new EstatusDTO(14, "INAC", "INACTIVO", "red", "I");
		
		// when
		when(estatusService.findById(Mockito.anyInt())).thenReturn(estatus);
		when(solicitudRepository.findById(Mockito.anyInt())).thenReturn(solicitudOp);
		Mensaje mensaje = underTest.deleteById(1);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);
	}

	@Test
	public void itShouldEmitirById() throws Exception {
		
		// given
		createUserDetails();

		estatus = new EstatusDTO(11, "", "", "", "");
		solicitud.setEstatus(estatus);
		Solicitud solicitudToEmitir = SolicitudMapper.toSolicitud(solicitud);
		solicitudToEmitir.setDocumentos(Arrays.asList(DocumentoMapper.toDocumento(documento)));
		Optional<Solicitud> solicitudOp = Optional.of(solicitudToEmitir);
		
		// when
		when(usuarioService.findByUserName(Mockito.anyString())).thenReturn(usuario);
		when(solicitudRepository.findById(Mockito.anyInt())).thenReturn(solicitudOp);
		Mensaje mensaje = underTest.emitirById(1);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);
	}

	@Test
	public void itShouldSendCorrection() throws Exception {
		
		// given
		RevisionDTO revision = new RevisionDTO(date, "ALGUNA", solicitud);
		estatus = new EstatusDTO(13, "", "", "", "");
		solicitud.setEstatus(estatus);
		Solicitud solicitudToEmitir = SolicitudMapper.toSolicitud(solicitud);
		Optional<Solicitud> solicitudOp = Optional.of(solicitudToEmitir);
		
		// when
		when(estatusService.findById(Mockito.anyInt())).thenReturn(estatus);
		when(revisionService.save(revision)).thenReturn(new Mensaje("", 1));
		when(solicitudRepository.findById(Mockito.anyInt())).thenReturn(solicitudOp);
		Mensaje mensaje = underTest.correction(revision,1);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);
	}

	@Test
	public void itShouldAcceptById() throws Exception {
		
		// given
		estatus = new EstatusDTO(15, "", "", "", "");
		solicitud.setEstatus(estatus);
		Solicitud solicitudToEmitir = SolicitudMapper.toSolicitud(solicitud);
		Optional<Solicitud> solicitudOp = Optional.of(solicitudToEmitir);
		
		// when
		when(estatusService.findById(Mockito.anyInt())).thenReturn(estatus);
		when(solicitudRepository.findById(Mockito.anyInt())).thenReturn(solicitudOp);
		Mensaje mensaje = underTest.acceptById(1);

		// then
		assertThat(mensaje.getResult()).isEqualTo(1);
	}

	@Test
	public void itShouldCheckDocumentsComplete() throws Exception {
		
		// given
		List<Integer> idTiposDocumentoObligatorios = Arrays.asList(1,2);
		TipoDocumentoDTO tipoDocumento2 = new TipoDocumentoDTO(2, "no unico","N","N", estatus);
		DocumentoDTO documento1 = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		DocumentoDTO documento2 = new DocumentoDTO(2, null, "JPG", "JPG", solicitud, tipoDocumento2);
		DocumentoDTO documento3 = new DocumentoDTO(3, null, "JPG", "JPG", solicitud, tipoDocumento2);
		documento1.setFile(file);
		documento2.setFile(file);
		documento3.setFile(file);
		List<Documento> documentos = Arrays.asList(DocumentoMapper.toDocumento(documento1),DocumentoMapper.toDocumento(documento2),DocumentoMapper.toDocumento(documento3));

		// when
		when(tipoDocumentoService.findAllIdDocumentosObligatorios()).thenReturn(idTiposDocumentoObligatorios);
		boolean areDocumentsComplete = underTest.areDocumentsComplete(documentos);

		// then
		assertThat(areDocumentsComplete).isTrue();
	}
	
	@Test
	public void itShouldCheckDocumentsAreNotComplete() throws Exception {
		
		// given
		List<Integer> idTiposDocumentoObligatorios = Arrays.asList(1,2,3);
		TipoDocumentoDTO tipoDocumento2 = new TipoDocumentoDTO(2, "no unico","N","N", estatus);
		DocumentoDTO documento1 = new DocumentoDTO(1, null, "JPG", "JPG", solicitud, tipoDocumento);
		DocumentoDTO documento2 = new DocumentoDTO(2, null, "JPG", "JPG", solicitud, tipoDocumento2);
		DocumentoDTO documento3 = new DocumentoDTO(3, null, "JPG", "JPG", solicitud, tipoDocumento2);
		documento1.setFile(file);
		documento2.setFile(file);
		documento3.setFile(file);
		List<Documento> documentos = Arrays.asList(DocumentoMapper.toDocumento(documento1),DocumentoMapper.toDocumento(documento2),DocumentoMapper.toDocumento(documento3));

		// when
		when(tipoDocumentoService.findAllIdDocumentosObligatorios()).thenReturn(idTiposDocumentoObligatorios);
		boolean areDocumentsComplete = underTest.areDocumentsComplete(documentos);

		// then
		assertThat(areDocumentsComplete).isFalse();
	}
	
	
	private void createUserDetails() {
		List<GrantedAuthority> grantList = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		UserDetails applicationUser = (UserDetails) new User("ADMIN", "123", grantList);
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);
	}

}
