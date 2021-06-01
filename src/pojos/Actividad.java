package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name = "actividad")
public class Actividad implements Serializable{
	
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="num_actividad")
	private Integer numActividad;
	@Column(name="num_un")
	private Integer numUn;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_tramo")
	private TramoHorario tramo;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_aula")
	private Aula aula;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="num_asignatura")
	private Asignatura asignatura;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="num_profesor")
	private Profesor profesor;
	
	@OneToOne(mappedBy = "actividad")
	private Guardia guardia;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "actividad" )
	private List<GrupoActividad> grupos;
	
	public Actividad() {
	}

	public Actividad(Integer Id, Integer numActividad, Integer numUn, TramoHorario tramo, Aula aula, Asignatura asignatura, Profesor profesor,
			List<GrupoActividad> grupos) {
		this.Id = Id;
		this.numActividad = numActividad;
		this.numUn = numUn;
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
	
	public Integer getNumUn() {
		return numUn;
	}

	public void setNumUn(Integer numUn) {
		this.numUn = numUn;
	}
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + ((numActividad == null) ? 0 : numActividad.hashCode());
		result = prime * result + ((numUn == null) ? 0 : numUn.hashCode());
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
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
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
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (numActividad == null) {
			if (other.numActividad != null)
				return false;
		} else if (!numActividad.equals(other.numActividad))
			return false;
		if (numUn == null) {
			if (other.numUn != null)
				return false;
		} else if (!numUn.equals(other.numUn))
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
		return "Actividad [Id=" + Id + ", numActividad=" + numActividad + ", numUn=" + numUn + ", tramo=" + tramo
				+ ", aula=" + aula + ", asignatura=" + asignatura + ", profesor=" + profesor + "]";
	}

}
