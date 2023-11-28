package es.deusto.prog3.examen.ord202201;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//La clase debe ser Serializable
public class RocketLaunch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Atributo estático para la conversión de fechas a String
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	public enum Status {
		SUCCESS,
		FAILURE
	}

	private String company;
	private LocalDateTime launchDate;
	private String location;
	private String detail;
	private float cost;
	private Status status;
	
	public RocketLaunch(String company, LocalDateTime launchDate, String location, String detail, float cost, boolean status) {
		this.company = company;
		this.launchDate = launchDate;
		this.location = location;
		this.detail = detail;
		this.cost = cost;
		this.status = status ? Status.SUCCESS : Status.FAILURE; 
	}
	
	public String getCompany() {
		return company;
	}
	
	public LocalDateTime getLaunchDate() {
		return launchDate;
	}

	public String getLocation() {
		return location;
	}

	public String getDetail() {
		return detail;
	}

	public float getCost() {
		return cost;
	}

	public Status getStatus() {
		return status;
	}
	/**
	 * Genera una cadena de texto con información del lanzamiento separada por ";".
	 * La cadena de texto incluye los atributos company, launchDate y status.
	 * @return String con el resultado.
	 */
	public String toCSVString() {
		return String.format("%s;%s;%s", company, formatter.format(launchDate), status);
	}
}