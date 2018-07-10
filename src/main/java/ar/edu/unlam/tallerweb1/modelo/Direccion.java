package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String street_number; 				
	private String route; 						
	private String locality;					
	private String administrative_area_level_1;
	private String country;				
	private String postal_code;
	
	
	@OneToOne(mappedBy="direccion")	  // RELACION CON EVENTO
	private Evento evento;
	
	
	
	// CONSTRUCTORES
	
	public Direccion() {

	}

	public Direccion(Long id, String street_number, String route, String locality, String administrative_area_level_1,
			String country, String postal_code) {

		this.id = id;
		this.street_number = street_number;
		this.route = route;
		this.locality = locality;
		this.administrative_area_level_1 = administrative_area_level_1;
		this.country = country;
		this.postal_code = postal_code;
	}

	
	
	// GETS SETS

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStreet_number() {
		return street_number;
	}


	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}


	public String getRoute() {
		return route;
	}


	public void setRoute(String route) {
		this.route = route;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	public String getAdministrative_area_level_1() {
		return administrative_area_level_1;
	}


	public void setAdministrative_area_level_1(String administrative_area_level_1) {
		this.administrative_area_level_1 = administrative_area_level_1;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostal_code() {
		return postal_code;
	}


	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
}
