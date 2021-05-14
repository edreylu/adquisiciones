package com.modules.sirsr.requisicion.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.modules.sirsr.capitulo.persistence.Capitulo;
import com.modules.sirsr.capitulo.persistence.CapituloRepository;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestaria;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestariaRepository;
import com.modules.sirsr.concepto.persistence.Concepto;
import com.modules.sirsr.concepto.persistence.ConceptoRepository;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.estatus.persistence.EstatusRepository;
import com.modules.sirsr.montoAdjudicacion.persistence.MontoAdjudicacion;
import com.modules.sirsr.montoAdjudicacion.persistence.MontoAdjudicacionRepository;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGasto;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGastoRepository;
import com.modules.sirsr.partidaGastoGenerica.persistence.PartidaGastoGenerica;
import com.modules.sirsr.partidaGastoGenerica.persistence.PartidaGastoGenericaRepository;
import com.modules.sirsr.prioridad.persistence.Prioridad;
import com.modules.sirsr.prioridad.persistence.PrioridadRepository;
import com.modules.sirsr.solicitud.persistence.Solicitud;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsable;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableRepository;

@DataJpaTest
public class RequisicionRepositoryTest{
	
	@Autowired
	private RequisicionRepository underTest;
	@Autowired
	private SolicitudRepository solicitudRepository;
	@Autowired
	private UnidadResponsableRepository unidadResponsableRepository;
	@Autowired
	private PrioridadRepository prioridadRepository;
	@Autowired
	private ClavePresupuestariaRepository clavePresupuestariaRepository;
	@Autowired
	private ObjetoDeGastoRepository objetoDeGastoRepository;
	@Autowired
	private PartidaGastoGenericaRepository partidaGastoGenericaRepository;
	@Autowired
	private ConceptoRepository conceptoRepository;
	@Autowired
	private CapituloRepository capituloRepository;
	@Autowired
	private MontoAdjudicacionRepository montoAdjudicacionRepository;
	@Autowired
	private EstatusRepository estatusRepository;

	private Date date;
	private Estatus estatus, estatus2;
	private UnidadResponsable unidadResponsable;
	private Prioridad prioridad;
	private Solicitud solicitud;
	private Requisicion requisicion;
	private ClavePresupuestaria clavePresupuestaria;
	private MontoAdjudicacion montoAdjudicacion;
	private ObjetoDeGasto objetoDeGasto;
	private PartidaGastoGenerica partidaGastoGenerica;
	private Concepto concepto;
	private Capitulo capitulo;

	@BeforeEach
	protected void setUp() throws Exception {
		
		date = Date.from(Instant.now());
		estatus = estatusRepository.save(new Estatus(1, "ACT", "ACTIVO", "red", "Activo"));
        estatus2 = estatusRepository.save(new Estatus(2, "REVI", "REVI", "red", "Activo"));
		unidadResponsable = unidadResponsableRepository.save(new UnidadResponsable("21", "prueba", date, date, estatus));
		prioridad = prioridadRepository.save(new Prioridad(1, "main", estatus));
		solicitud = new Solicitud(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable);
		solicitud = solicitudRepository.save(solicitud);
		capitulo = capituloRepository.save(new Capitulo(1, "", "", date, date, estatus));
		concepto = conceptoRepository.save(new Concepto(1, "algo", "", date, date, capitulo, estatus));
		partidaGastoGenerica = partidaGastoGenericaRepository.save(new PartidaGastoGenerica(1, "", "", date, date, estatus, concepto));
		objetoDeGasto = objetoDeGastoRepository.save(new ObjetoDeGasto("21", "", "", date, date, partidaGastoGenerica, estatus));
		clavePresupuestaria = clavePresupuestariaRepository.save(new ClavePresupuestaria(1, "2021", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", objetoDeGasto, unidadResponsable, estatus));
		montoAdjudicacion = montoAdjudicacionRepository.save(new MontoAdjudicacion(1, "", new BigDecimal(12), new BigDecimal(12), estatus));
		requisicion = underTest.save(new Requisicion(1, 1, 1200.00, clavePresupuestaria, estatus, montoAdjudicacion, solicitud));
	}

	@AfterEach
	protected void tearDown() throws Exception {
		underTest.deleteAll();
		montoAdjudicacionRepository.deleteAll();		
		clavePresupuestariaRepository.deleteAll();
		objetoDeGastoRepository.deleteAll();
		partidaGastoGenericaRepository.deleteAll();
		conceptoRepository.deleteAll();
		capituloRepository.deleteAll();
		solicitudRepository.deleteAll();
		prioridadRepository.deleteAll();
		unidadResponsableRepository.deleteAll();
		estatusRepository.deleteAll();
		
	}
	
	@Test
	void itShouldFindByIdSolicitud() throws Exception {
		
		//given
		
		
		//when
		List<Requisicion> requisiciones = underTest.findByIdSolicitud(solicitud.getIdSolicitud());
		
		//then
		assertThat(requisiciones.size()).isEqualTo(1);
		
	}

}
