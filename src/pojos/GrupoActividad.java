package pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name = "grupoactividad")
public class GrupoActividad implements Serializable{
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="numGrupo")
	private Grupo grupo;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="numGrupo")
	private Actividad actividad;

	public GrupoActividad() {
	}

	public GrupoActividad(Grupo grupo, Actividad actividad) {
		this.grupo = grupo;
		this.actividad = actividad;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actividad == null) ? 0 : actividad.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		GrupoActividad other = (GrupoActividad) obj;
		if (actividad == null) {
			if (other.actividad != null)
				return false;
		} else if (!actividad.equals(other.actividad))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoActividad [grupo=" + grupo + ", actividad=" + actividad + "]";
	}

}
