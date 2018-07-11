package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;

@Controller
public class ControladorEvento {
	
	@Inject
	private ServicioEvento servicioEvento;
	

	public ServicioEvento getServicioEvento() {
		return servicioEvento;
	}

	public void setServicioEvento(ServicioEvento servicioEvento) {
		this.servicioEvento = servicioEvento;
	}


	// FORMULARIO PARA LA CREACION DEL EVENTO
	@RequestMapping(path = "/crearEvento")
	public ModelAndView crearEvento() {
		
		Evento evento = new Evento();
		ModelMap model = new ModelMap();
		model.put("keyEvento", evento);
		
		return new ModelAndView ("crearEvento",model);
	}
	
	
	// DATOS CARGADOS DEL EVENTO VAN A LA BASE DE DATOS
	@RequestMapping(path="/crearEvento", method= RequestMethod.POST)
	public ModelAndView CargarEventoABD(@ModelAttribute("keyEvento") Evento evento){
		
			servicioEvento.crearEventoService(evento);
			
			return new ModelAndView("redirect:/homeAdmin");
	}

	
	// EDITAR EVENTO
	@RequestMapping(value = "/actualizarEvento")
	public ModelAndView actualizarEvento( @RequestParam("id") Long id) {
		
		Evento evento = servicioEvento.buscarEventoPorIdService(id);
		ModelMap model = new ModelMap();
		model.put("keyEvento", evento);
		
		return new ModelAndView("actualizarEvento", model);
	}
	
	
	@RequestMapping(path = "/validarActualizarEvento", method = RequestMethod.POST)
	public ModelAndView validarActualizarEvento(@ModelAttribute("evento") Evento evento, HttpServletRequest request) {
		
		servicioEvento.actualizarEventoService(evento);		

		return new ModelAndView("redirect:/homeAdmin");

	}
	
	// MOSTRAR DETALLE DEL EVENTO
	@RequestMapping(path = "/detalleEvento")
	public ModelAndView detalleEvento(@RequestParam("id") Long id) {
		
		ModelMap model = new ModelMap();
		Evento evento = servicioEvento.buscarEventoPorIdService(id);
		model.put("keyEvento", evento);
		
		return new ModelAndView("detalleEvento", model);
	}
	
	
	// BUSCAR EVENTOS
	@RequestMapping(path = "/filtros-Busqueda", method = RequestMethod.POST)
	public ModelAndView buscarEventos(@ModelAttribute("evento") Evento evento) {
		ModelMap model = new ModelMap();
		
		 List<Evento> resultadoDeEventos = servicioEvento.buscarEventosService(evento.getNombre());
		 model.put("keyListarEventos", resultadoDeEventos);
		return new ModelAndView("inicio", model);
	}
	
	
	
} // FIN CONTROLLER
