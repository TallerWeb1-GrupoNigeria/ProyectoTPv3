package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;


@Controller
public class ControladorCarrito {
	
	
	@Inject
	private ServicioEvento servicioEvento;
	
	@Inject
	private ServicioCarrito servicioCarrito;
	

	public ServicioCarrito getServicioCarrito() {
		return servicioCarrito;
	}

	public void setServicioCarrito(ServicioCarrito servicioCarrito) {
		this.servicioCarrito = servicioCarrito;
	}
	
	public ServicioEvento getServicioEvento() {
		return servicioEvento;
	}

	public void setServicioEvento(ServicioEvento servicioEvento) {
		this.servicioEvento = servicioEvento;
	}
	
	

	// TODO: PARA QUE FUNCIONE EL AGREGAR HAY QUE CARGAR AL MENOS UN USUARIO EN LA BASE DE DATOS!!!!!!!!!!!!!!
	// AGREGAR EVENTO CARRITO
	@RequestMapping(path = "/agregarEventoAlCarrito")
	public ModelAndView agregarEventoAlCarrito(@RequestParam("id") Long id) {
		
		Usuario usuario = new Usuario(1L,"admin","admin@admin.com","1234","1234","admin");   // TODO:  falta ver como obtener el usuario de sesion actual(logeado)		
		
		Evento evento = servicioEvento.buscarEventoPorIdService(id);
		servicioCarrito.agregarEventoACarritoSERVICE(usuario, evento);

		return new ModelAndView("redirect:/misEventos");
	}
	
	
	// LISTAR EVENTOS POR USUARIO
	@RequestMapping(path="/misEventos")
	public ModelAndView misEventos(){ 
			
		ModelMap model = new ModelMap();
		model.put("keyListadoEventos", servicioCarrito.listarTodoCarritoSERVICE());
		
		return new ModelAndView("misEventos",model);
	 }
	
	
	// ELIMINAR EVENTO DE CARRITO
	@RequestMapping(path = "/eliminarEventoDeCarrito")
	public ModelAndView eliminarEventoDeCarrito(@RequestParam("id") Long idCarrito) {

		servicioCarrito.eliminarEventoDeCarritoSERVICE(idCarrito);

		return new ModelAndView("redirect:/misEventos");
	}
	
	
	
	// VACIAR CARRITO
	@RequestMapping(path = "/vaciarCarrito")
	public ModelAndView vaciarCarrito() {
		
		Usuario usuario = new Usuario(1L,"admin","admin@admin.com","1234","1234","admin");
		
		servicioCarrito.vaciarCarritoSERVICE(usuario);

		return new ModelAndView("redirect:/misEventos");
	}
	
	

	
}
