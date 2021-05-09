package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Actividad implements Serializable{
	
	@Id
	@JoinColumn(name="num_actividad")
	private Integer numActividad;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_tramo")
	private TramoHorario tramo;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_aula")
	private Aula aula;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_asignatura")
	private Asignatura asignatura;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_profesor")
	private Profesor profesor;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "grupoactividad" )
	private List<GrupoActividad> grupos;
	
	public Actividad() {
	}

	public Actividad(Integer numActividad, TramoHorario tramo, Aula aula, Asignatura asignatura, Profesor profesor,
			List<GrupoActividad> grupos) {
		this.numActividad = numActividad;
		this.tramo = tramo;
		this.aula = aula;
		this.asignatura = asignatura;
		this.profesor = profesor;
		this.grupos = grupos;
	}

	public Integer getNumActividad() {
		return numActividad;
	}

	public void setNumActividad(Integer numActividad) {
		this.numActividad = numActividad;
	}

	public TramoHorario getTramo() {
		return tramo;
	}

	public void setTramo(TramoHorario tramo) {
		this.tramo = tramo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<GrupoActividad> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoActividad> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((numActividad == null) ? 0 : numActividad.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((tramo == null) ? 0 : tramo.hashCode());
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
		Actividad other = (Actividad) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (numActividad == null) {
			if (other.numActividad != null)
				return false;
		} else if (!numActividad.equals(other.numActividad))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (tramo == null) {
			if (other.tramo != null)
				return false;
		} else if (!tramo.equals(other.tramo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actividad [numActividad=" + numActividad + ", tramo=" + tramo + ", aula=" + aula
				+ ", asignatura=" + asignatura + ", profesor=" + profesor + "]";
	}
}
