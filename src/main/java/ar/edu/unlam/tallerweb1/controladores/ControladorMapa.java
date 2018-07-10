package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UbicacionJson;


@Controller
public class ControladorMapa {

	
	@RequestMapping(path = "/inicioHome2",method=RequestMethod.POST)
	public ModelAndView inicioPost(@RequestBody UbicacionJson ubicacion) {
		
		ModelMap model = new ModelMap();
//		model.put("keyListarEventos", servicioEvento.listarEventosService());
//		
//		Evento e1 = new Evento("evento json", "", "20/12/2019", "12:00", "02:00", null,null , null, null, null, null, null, null, null, null , null, "si");
		
		System.out.println("dire:"+ubicacion.getFormatted_address());
		
//		 Direccion d1 = new Direccion(1L,ubicacion.getStreet_number(), ubicacion.getStreet_number(), ubicacion.getLocality(), 
//				 					ubicacion.getAdministrative_area_level_1(), ubicacion.getCountry(), ubicacion.getPostal_code(),
//				 					ubicacion.getLongitud(), ubicacion.getLatitud());
//		 model.put("direccion", d1);

		return new ModelAndView ("inicio",model);
	}

}
