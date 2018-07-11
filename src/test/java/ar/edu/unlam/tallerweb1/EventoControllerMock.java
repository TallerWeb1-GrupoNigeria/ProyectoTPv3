package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEventoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import ar.edu.unlam.tallerweb1.controladores.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class EventoControllerMock extends SpringTest {
	 	
	 Evento eventoMock = mock(Evento.class);
     HttpServletRequest requestMock = mock(HttpServletRequest.class);
     HttpSession sessionMock = mock(HttpSession.class);
     ServicioEvento servicioEventoMock= mock(ServicioEventoImpl.class);
     ControladorEvento controladorEvento = new ControladorEvento();
          
     @Before
 		public void ini(){
 		controladorEvento.setServicioEvento(servicioEventoMock);
 		}

    @Test
    @Transactional
    @Rollback(true)
    public void cargarEventoDeberiaIrHomeAdmin() {
    	when(eventoMock.getId()).thenReturn((long) 1);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        ModelAndView modelAndView = controladorEvento.CargarEventoABD(eventoMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/homeAdmin");
    }

    @Test
    @Transactional
    @Rollback(true)
    public void idExistenteDeberiaIrActualizarEvento() {
        when(eventoMock.getId()).thenReturn((long) 1);
        when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        requestMock.setAttribute("id", eventoMock.getId());
        ModelAndView modelAndView = controladorEvento.actualizarEvento(eventoMock.getId());
        //ModelAndView modelAndView = controladorLogin.registroValidar(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("actualizarEvento");
    }
    @Test
    @Transactional
    @Rollback(true)
    public void idNoExistenteDeberiaIrHomeAdmin() {
        when(eventoMock.getId()).thenReturn((long) 9);
        //when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        ModelAndView modelAndView = controladorEvento.actualizarEvento(eventoMock.getId());
        assertThat(modelAndView.getViewName()).isEqualTo("homeAdmin");
    }
    @Test
    @Transactional
    @Rollback(true)
    public void idNoExistenteDeberiaIrHomeAdmin2() {
        when(eventoMock.getId()).thenReturn((long) 2);
        when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        ModelAndView modelAndView = controladorEvento.actualizarEvento(eventoMock.getId());
        assertThat(modelAndView.getViewName()).isEqualTo("homeAdmin");
    }

    @Test
    @Transactional
    @Rollback(true)
    public void validarActualizarEventoDeberiaIrHomeAdmin() {
        when(requestMock.getSession()).thenReturn(sessionMock);
        servicioEventoMock.actualizarEventoService(eventoMock);
        ModelAndView modelAndView = controladorEvento.validarActualizarEvento(eventoMock);
        //ModelAndView modelAndView = controladorLogin.registroValidar(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/homeAdmin");
    }
    
// // MOSTRAR DETALLE DEL EVENTO
// 	@RequestMapping(path = "/detalleEvento")
// 	public ModelAndView detalleEvento(@RequestParam("id") Long id) {
// 		
// 		ModelMap model = new ModelMap();
// 		Evento evento = servicioEvento.buscarEventoPorIdService(id);
// 		model.put("keyEvento", evento);
// 		
// 		return new ModelAndView("detalleEvento", model);
// 	}

    @Test
    @Transactional
    @Rollback(true)
    public void idValidoDeberiaDirigirmeDetalleEvento() {
        when(eventoMock.getId()).thenReturn((long) 1);
        when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        ModelAndView modelAndView = controladorEvento.detalleEvento(eventoMock.getId());
        //ModelAndView modelAndView = controladorLogin.registroValidar(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("detalleEvento");
    }
    @Test
    @Transactional
    @Rollback(true)
    public void idInvalidoDeberiaDirigirmeActualizarEvento() {
        when(eventoMock.getId()).thenReturn((long)4);
        when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        ModelAndView modelAndView = controladorEvento.detalleEvento(eventoMock.getId());
        //ModelAndView modelAndView = controladorLogin.registroValidar(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("homeAdmin");
    }

}
 
