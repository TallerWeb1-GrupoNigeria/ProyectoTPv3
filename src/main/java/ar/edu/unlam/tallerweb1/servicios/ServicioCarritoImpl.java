package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.CarritoDao;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service
public class ServicioCarritoImpl implements ServicioCarrito {

	
	@Inject
	private CarritoDao carritoDao;
	
	
	@Override
	public void agregarEventoACarritoSERVICE(Usuario usuario, Evento evento) {
		carritoDao.agregarEventoACarrito(usuario, evento);
	}
	
	public List<Carrito> listarTodoCarritoSERVICE() {
		return carritoDao.listarTodoCarrito();
	}
	
	public void vaciarCarritoSERVICE(Usuario usuario) {
		carritoDao.vaciarCarrito(usuario);
	}
	
	
	public void eliminarEventoDeCarritoSERVICE(Long idCarrito) {
		carritoDao.eliminarEventoDeCarrito(idCarrito);
	}
	
	public List<Evento> listarEventosDeCarritoXUsuarioSERVICE(Usuario usuario) {
		return carritoDao.listarEventosDeCarritoXUsuario(usuario);
	}
	
	
	
}
