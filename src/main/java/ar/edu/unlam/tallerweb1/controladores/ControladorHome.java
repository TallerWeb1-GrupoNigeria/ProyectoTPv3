package ar.edu.unlam.tallerweb1.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;

@Controller
public class ControladorHome {

	
	@Inject
	private ServicioEvento servicioEvento;

	
	public ServicioEvento getServicioEvento() {
		return servicioEvento;
	}


	public void setServicioEvento(ServicioEvento servicioEvento) {
		this.servicioEvento = servicioEvento;
	}


	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio(HttpServletRequest request) {
		System.out.println("ejemplo prueba");
		request.getSession().getAttribute("valor");
		
		return new ModelAndView("redirect:/inicioHome");
	}
	
	
	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	
	@RequestMapping(path = "/inicio", method = RequestMethod.GET)
	public ModelAndView irAInicio() {
		return new ModelAndView("inicio");
	}
	
	@RequestMapping(path = "/inicioLive")
	public ModelAndView irAInicioLive(@ModelAttribute("evento") Evento evento,HttpServletRequest request) {
		ModelMap model = new ModelMap();
		List<Evento> listadoEventos3 = servicioEvento.listarTodosLosEventosEstadoEnProcesoService();
		if(listadoEventos3.isEmpty()) {
			  List<Evento> listadoEventos = servicioEvento.listarTodosEventosService();
			  model.put("keyListarEventos", listadoEventos);	
			  return new ModelAndView("inicio", model);
		}
		model.put("keyListarEventos", listadoEventos3);	
		return new ModelAndView("inicio", model);
	}
	
	
	@RequestMapping(path = "/inicioHome")
	public ModelAndView inicio(@ModelAttribute("evento") Evento evento, HttpServletRequest request) {
		
			
			ModelMap model = new ModelMap();
		
	//	model.put("keySelectPrestaciones", servicioPrestacion.listarPrestacionService());
	  List<Evento> listadoEventos = servicioEvento.listarTodosEventosService();
  	
		Iterator<Evento> cargaEstados = listadoEventos.listIterator();
		while (cargaEstados.hasNext()) {
			Evento miEvento = cargaEstados.next();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			//String fecha = sdf.format(new Date()); 
			//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     		String fechaActualString = sdf.format(new Date());
     		String fechaEventoString = sdf.format(miEvento.getFecha());
     		Date fechaActual = new Date();
			SimpleDateFormat sdfHora = new SimpleDateFormat("HH");
			String horaActual = sdfHora.format(new Date());
			int horaActualInt = Integer.parseInt(horaActual);
			//String horaEvento = miEvento.getHoraInicio();
			//char[] horaInicio = miEvento.getHoraInicio().toCharArray();
			String[] horaOMinuto = miEvento.getHoraInicio().split(":");
			int horaInicialEvento = Integer.parseInt(horaOMinuto[0]);
			String[] horaOMinutoFin = miEvento.getHoraFin().split(":");
			int horaFinalEvento = Integer.parseInt(horaOMinutoFin[0]);
			
     		if(fechaActualString.equals(fechaEventoString)) {
     			for (int i=horaInicialEvento; i<horaFinalEvento ; i++ ) {
     				if(horaActualInt==i) {
						miEvento.setEstado("en curso");
						request.getSession().setAttribute("Live", "si");
						break;
					}else if(horaFinalEvento<horaActualInt) {
						miEvento.setEstado("evento caducado");
					}else {
						miEvento.setEstado("hoy");
					}
     			}
     			
     		}else if (miEvento.getFecha().before(fechaActual) ) {
				miEvento.setEstado("evento caducado");
			}else if(miEvento.getFecha().after(fechaActual)) {
				miEvento.setEstado("evento proximo");
			}else {
				miEvento.setEstado("fecha invalida");
			}
			servicioEvento.actualizarEventoService(miEvento);	
		}
		//List<Evento>  listadoEventos2 = servicioEvento.listarTodosLosEventosEstadoEnProximosService();
		//List<Evento> listadoEventos1 = servicioEvento.listarTodosLosEventosEstadoCaducadoService();
		 // List<Evento> listadoEventos3 = servicioEvento.listarTodosLosEventosEstadoEnProcesoService();
		model.put("keyListarEventos", listadoEventos);		
		return new ModelAndView ("inicio",model);
	}

	@RequestMapping(path="/homeAdmin")
	public ModelAndView homeAdmin(){ 
		
		ModelMap model = new ModelMap();
		model.put("keyListarEventos", servicioEvento.listarTodosEventosService());
		
		//model.put("keySelectPrestaciones", servicioPrestacion.listarPrestacionService());
		return new ModelAndView("homeAdmin",model);
	 }
		
	

}
