package pojos;

import java.time.LocalDate;
import java.time.LocalTime;

public class GuardiasData {
	
	private String profesor;
	private LocalTime hora;
	private LocalDate fecha;
	private String trabajo;
	private int id;
	private String aula;
	
	public GuardiasData(String profesor, LocalTime hora, LocalDate fecha, String trabajo, int id, String aula) {
		this.id = id;
		this.profesor = profesor;
		this.hora = hora;
		this.fecha = fecha;
		this.trabajo = trabajo;
		this.aula = aula;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	
	
	

}
