package com.modules.sirsr.documento.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.formula.functions.Now;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.estatus.persistence.EstatusRepository;
import com.modules.sirsr.prioridad.persistence.Prioridad;
import com.modules.sirsr.prioridad.persistence.PrioridadRepository;
import com.modules.sirsr.solicitud.persistence.Solicitud;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;
import com.modules.sirsr.tipoDocumento.persistence.TipoDocumento;
import com.modules.sirsr.tipoDocumento.persistence.TipoDocumentoRepository;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsable;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableRepository;

@DataJpaTest
public class DocumentoRepositoryTest {

	@Autowired
	private DocumentoRepository underTest;
	@Autowired
	private EstatusRepository estatusRepository;
	@Autowired
	private SolicitudRepository solicitudRepository;
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	@Autowired
	private PrioridadRepository prioridadRepository;
	@Autowired
	private UnidadResponsableRepository unidadResponsableRepository;

	private Solicitud solicitud;
	private Date date;
	private Estatus estatus;
	private UnidadResponsable unidadResponsable;
	private Prioridad prioridad;
	private TipoDocumento tipoDocumento;

	@BeforeEach
	protected void setUp() throws Exception {
		date = Date.from(Instant.now());
		estatus = estatusRepository.save(new Estatus(1, "ACT", "ACTIVO", "red", "Activo"));
		unidadResponsable = unidadResponsableRepository
				.save(new UnidadResponsable("21", "prueba", date, date, estatus));
		prioridad = prioridadRepository.save(new Prioridad(1, "main", estatus));
		tipoDocumento = tipoDocumentoRepository.save(new TipoDocumento(1, "unico", "S", "S", estatus));
		
	}

	@AfterEach
	protected void tearDown() {
		underTest.deleteAll();
		solicitudRepository.deleteAll();
		tipoDocumentoRepository.deleteAll();
		prioridadRepository.deleteAll();
		unidadResponsableRepository.deleteAll();
		estatusRepository.deleteAll();
	}

	@Test
	void itShouldFindDocumentsByIdSolicitud() throws Exception {
		
		//given
		solicitud = solicitudRepository.save(new Solicitud(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable));
		underTest.save(new Documento(3, null, "JPG", "JPG", solicitud, tipoDocumento));
		underTest.save(new Documento(2, null, "PNG", "PNG", solicitud, tipoDocumento));
	
		//when
		List<Documento> documentosExpected = underTest.findByIdSolicitud(solicitud.getIdSolicitud());
		
		//then
		assertThat(documentosExpected.get(0).getIdDocumento()).isEqualTo(1);
	}

}
