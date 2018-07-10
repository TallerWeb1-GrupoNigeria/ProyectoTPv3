package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CarritoDao;
import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml" })
public class CarritoDAOTest {

	
	@Inject
	private EventoDao eventoDao;
	
	@Inject
	private CarritoDao carritoDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testCrearCarrito() {
		
		// INICIALIZACION
		Evento evento1 = new Evento(1L,"PrimerEvento", "Este es el primer evento","01/01/2001","21:00","23:00");
		Evento evento2 = new Evento(2L,"SegundoEvento", "Este es el segundo evento","01/01/2001","21:00","23:00");
		Evento evento3 = new Evento(3L,"TercerEvento", "Este es el tercer evento","01/01/2001","21:00","23:00");
		eventoDao.crearEvento(evento1);
		eventoDao.crearEvento(evento2);
		eventoDao.crearEvento(evento3);
		
		Usuario usuario1 = new Usuario(1L, "Abel", "abel@gmail.com", "1234", "1234", "user");
		Usuario usuario2 = new Usuario(2L, "Belen", "belen@gmail.com", "1234", "1234", "user");
		usuarioDao.crearUsuario(usuario1);
		usuarioDao.crearUsuario(usuario2);
		
		Carrito carrito1 = new Carrito(1L,evento1,usuario1);
		Carrito carrito2 = new Carrito(2L,evento2,usuario1);
		Carrito carrito3 = new Carrito(3L,evento3,usuario1);
		
		
		
		// OPERACION
		carritoDao.crearCarrito(carrito1);
		carritoDao.crearCarrito(carrito2);
		carritoDao.crearCarrito(carrito3);
		
		// VERIFICACION
		List<Carrito> listadoDelCarrito = carritoDao.listarTodoCarrito();
		
		assertThat(listadoDelCarrito).hasSize(3);
		
		for (Carrito car : listadoDelCarrito) {
			assertThat(car.getUsuario()).isEqualTo(usuario1);
		}
		
/*		// VERIFICACION 2
		List<Evento> listadoEventosCarritoUsuario2 = carritoDao.listarEventosDeCarritoXUsuario(usuario2);
		assertThat(listadoEventosCarritoUsuario2).hasSize(1);	*/
		
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testAgregarEventoACarrito() {
		
		// INICIALIZACION
		Evento evento1 = new Evento(1L,"PrimerEvento", "Este es el primer evento","01/01/2001","21:00","23:00");
		Evento evento2 = new Evento(2L,"SegundoEvento", "Este es el segundo evento","01/01/2001","21:00","23:00");
		Evento evento3 = new Evento(3L,"TercerEvento", "Este es el tercer evento","01/01/2001","21:00","23:00");
		eventoDao.crearEvento(evento1);
		eventoDao.crearEvento(evento2);
		eventoDao.crearEvento(evento3);
		
		Usuario usuario1 = new Usuario(1L, "Abel", "abel@gmail.com", "1234", "1234", "user");
		Usuario usuario2 = new Usuario(2L, "Belen", "belen@gmail.com", "1234", "1234", "user");
		usuarioDao.crearUsuario(usuario1);
		usuarioDao.crearUsuario(usuario2);
		
		
		// OPERACION
		carritoDao.agregarEventoACarrito(usuario1, evento1);
		carritoDao.agregarEventoACarrito(usuario1, evento2);
		carritoDao.agregarEventoACarrito(usuario1, evento3);
		

		//VERIFICACION	
		List<Carrito> listadoTodoCarrito = carritoDao.listarTodoCarrito();
		
		assertThat(listadoTodoCarrito).hasSize(1);
		
	}
	
	
	
	
	
	
	

} // FIN CARRITO TEST





/*

package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unlam.tallerweb1.dao.ReunionDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Reunion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml" })
public class TestReunionDao {

    @Inject
    private ReunionDao reunionDao;

    @Inject
    private UsuarioDao usuarioDao;

    private Usuario usuario;

    private Reunion reunion;

    @Test
    public void sacarUsuarioDeReunion() {

         Inicialización 
        usuario = new Usuario();
        usuario.setId(2L);
        usuario.setEmail("email2");
        usuario.setPassword("pass2");
        usuario.setApellido("apellido2");
        usuario.setNombre("nombre2");

        usuarioDao.registrarUsuario(usuario);

        Evento evento = new Evento();

        reunion = new Reunion();
        reunion.setidReunion(200L);
        reunion.setNombreReunion("Nombre 1");
        reunion.setEvento(evento);
        reunionDao.crearReunionDAO(reunion);
        
        reunionDao.agregarUsuarioAReunionDAO(reunion, usuario);

        Usuario usuarioConReunion = usuarioDao.consultarUsuario(usuario);
        List<Reunion> reunionConUsuario = reunionDao.busquedaReunionesDao("Nombre 1");

        assertThat(usuarioConReunion.getReuniones()).hasSize(1);
        assertThat(reunionConUsuario.get(1).getUsuarios()).hasSize(1);

         Operación 
        reunionDao.salirDeReunionDao(usuario, reunion);

         Verificación 
        Usuario usuarioSinReunion = usuarioDao.consultarUsuario(usuario);
        List<Reunion> reunionSinUsuario = reunionDao.busquedaReunionesDao("Nombre 1");

        assertThat(usuarioSinReunion.getReuniones()).isEmpty();
        assertThat(reunionSinUsuario.get(1).getUsuarios()).isEmpty();
    }
}

*/
