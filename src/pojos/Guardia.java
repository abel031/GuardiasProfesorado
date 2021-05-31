package pojos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity(name="guardia")
public class Guardia implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="num_Guardia")
	private Integer numGuardia;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="profesor_sustituo")
	private Profesor sustituto;
	
	@OneToOne
	@JoinColumn(name = "actividad")
	private Actividad actividad;
	
	@Column(name ="tieneTrabajo")
	private Boolean trabajo;
	
	@Column(name="trabajo")
	private String trabajoList;
	
	@Column(name="dia")
	private Date dia;

	public Guardia() {
		super();
	}

	public Guardia(Integer numGuardia, Profesor sustituto, Actividad actividad, Boolean trabajo, String trabajoList,
			Date dia) {
		super();
		this.numGuardia = numGuardia;
		this.sustituto = sustituto;
		this.actividad = actividad;
		this.trabajo = trabajo;
		this.trabajoList = trabajoList;
		this.dia = dia;
	}

	public Integer getNumGuardia() {
		return numGuardia;
	}

	public void setNumGuardia(Integer numGuardia) {
		this.numGuardia = numGuardia;
	}

	public Profesor getSustituto() {
		return sustituto;
	}

	public void setSustituto(Profesor sustituto) {
		this.sustituto = sustituto;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Boolean getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Boolean trabajo) {
		this.trabajo = trabajo;
	}

	public String getTrabajoList() {
		return trabajoList;
	}

	public void setTrabajoList(String trabajoList) {
		this.trabajoList = trabajoList;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actividad == null) ? 0 : actividad.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((numGuardia == null) ? 0 : numGuardia.hashCode());
		result = prime * result + ((sustituto == null) ? 0 : sustituto.hashCode());
		result = prime * result + ((trabajo == null) ? 0 : trabajo.hashCode());
		result = prime * result + ((trabajoList == null) ? 0 : trabajoList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guardia other = (Guardia) obj;
		if (actividad == null) {
			if (other.actividad != null)
				return false;
		} else if (!actividad.equals(other.actividad))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (numGuardia == null) {
			if (other.numGuardia != null)
				return false;
		} else if (!numGuardia.equals(other.numGuardia))
			return false;
		if (sustituto == null) {
			if (other.sustituto != null)
				return false;
		} else if (!sustituto.equals(other.sustituto))
			return false;
		if (trabajo == null) {
			if (other.trabajo != null)
				return false;
		} else if (!trabajo.equals(other.trabajo))
			return false;
		if (trabajoList == null) {
			if (other.trabajoList != null)
				return false;
		} else if (!trabajoList.equals(other.trabajoList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Guardia [numGuardia=" + numGuardia + ", sustituto=" + sustituto + ", actividad=" + actividad
				+ ", trabajo=" + trabajo + ", trabajoList=" + trabajoList + ", dia=" + dia + "]";
	}
	
}
