package com.modules.sirsr.solicitud.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.estatus.persistence.EstatusRepository;
import com.modules.sirsr.prioridad.persistence.Prioridad;
import com.modules.sirsr.prioridad.persistence.PrioridadRepository;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsable;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableRepository;

@DataJpaTest
public class SolicitudRepositoryTest {

	@Autowired
	private SolicitudRepository underTest;

	@Autowired
	private UnidadResponsableRepository unidadResponsableRepository;

	@Autowired
	private PrioridadRepository prioridadRepository;

	@Autowired
	private EstatusRepository estatusRepository;

	private Date date;
	private Estatus estatus, estatus2;
	private UnidadResponsable unidadResponsable;
	private Prioridad prioridad;

	@BeforeEach
	protected void setUp() throws Exception {
		date = Date.from(Instant.now());
		estatus = estatusRepository.save(new Estatus(1, "ACT", "ACTIVO", "red", "Activo"));
        estatus2 = estatusRepository.save(new Estatus(2, "REVI", "REVI", "red", "Activo"));
		unidadResponsable = unidadResponsableRepository.save(new UnidadResponsable("21", "prueba", date, date, estatus));
		prioridad = prioridadRepository.save(new Prioridad(1, "main", estatus));
		
		underTest.save(new Solicitud(date, 2021, 10, "recreativo", estatus, prioridad, unidadResponsable));
        underTest.save(new Solicitud(date, 2021, 10, "otro", estatus2, prioridad, unidadResponsable));
	}

	@AfterEach
	protected void tearDown() throws Exception {
		underTest.deleteAll();
		prioridadRepository.deleteAll();
		unidadResponsableRepository.deleteAll();
		estatusRepository.deleteAll();
	}

	@Test
	public void itShouldFindByClaveUr() throws Exception {
		
		//given
		
		
		//when
		List<Solicitud> solicitudes = underTest.findByClaveUr("21", Sort.by(Sort.Direction.DESC, "idSolicitud"));
		
		//then
		assertThat(solicitudes.size()).isEqualTo(2);
	}

	@Test
	public void itShouldFindByIdEstatusGreaterThanEqual() throws Exception {
		
		//given
        
        
		//when
        List<Solicitud> solicitudes = underTest.findByIdEstatusGreaterThanEqual(2);
        
		//then
        assertThat(solicitudes.size()).isEqualTo(1);
	}

}
