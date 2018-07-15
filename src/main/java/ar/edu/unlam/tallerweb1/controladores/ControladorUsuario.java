package ar.edu.unlam.tallerweb1.controladores;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioUsuario, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@SuppressWarnings("unused")
	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping("/homeUsuario")
	public ModelAndView iraMenuUsuario() {
		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("homeUsuario", modelo);
	}
		
	// EDITAR Usuario
	
		@RequestMapping(value = "/actualizarUsuario")
		public ModelAndView actualizarUsuario(@RequestParam ("id") Long id) {
			Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(id);
			
			ModelMap model = new ModelMap();
			model.put("keyUsuario", usuario);
			
			return new ModelAndView("actualizarPerfil", model);
		}
		
		@RequestMapping(value ="/validarActualizarUsuario")
		public ModelAndView validarActualizarUsuario(@ModelAttribute("keyUsuario") Usuario usuario,HttpServletRequest request) {
			servicioUsuario.actualizarUsuarioService(usuario);
			Usuario usuarioActualizado = servicioUsuario.buscarUsuarioXIdSERVICE(usuario.getId());
			ModelMap model = new ModelMap();
			model.put("KeyUsuario", usuarioActualizado);
			request.getSession().setAttribute("nombre", usuarioActualizado.getNombre());
			request.getSession().setAttribute("foto", usuarioActualizado.getFoto());
			return new ModelAndView("actualizarPerfil", model);	
		}
		
	
	// LISTAR TODOS LOS USUARIOS
	@RequestMapping(path = "/listarUsuarios")
	public ModelAndView listarUsuarios() {
		
		ModelMap model = new ModelMap();
		model.put("keyListarUsuarios", servicioUsuario.listarTodosLosUsuariosSERVICE());
		
		return new ModelAndView ("listarUsuarios",model);
	}
		
}