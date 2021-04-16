package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Asignatura implements Serializable{
	
	@Id
	@JoinColumn(name="num_asignatura")
	private Integer numAsignatura;
	private String abreviatura;
	private String nombre;
	private String nivel;
	private String codigo;
	private String curso;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "actiidad" )
	private List<Actividad> actividades;
	
	public Asignatura() {
	}
	
	public Asignatura(Integer numAsignatura, String abreviatura, String nombre, String nivel, String codigo,
			String curso, List<Actividad> actividades) {
		this.numAsignatura = numAsignatura;
		this.abreviatura = abreviatura;
		this.nombre = nombre;
		this.nivel = nivel;
		this.codigo = codigo;
		this.curso = curso;
		this.actividades = actividades;
	}

	public Integer getNumAsignatura() {
		return numAsignatura;
	}

	public void setNumAsignatura(Integer numAsignatura) {
		this.numAsignatura = numAsignatura;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numAsignatura == null) ? 0 : numAsignatura.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numAsignatura == null) {
			if (other.numAsignatura != null)
				return false;
		} else if (!numAsignatura.equals(other.numAsignatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignatura [numAsignatura=" + numAsignatura + ", abreviatura=" + abreviatura + ", nombre=" + nombre
				+ ", nivel=" + nivel + ", codigo=" + codigo + ", curso=" + curso + "]";
	}
	
	

}
