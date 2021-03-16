package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Profesor implements Serializable{
	
	@Id
	@JoinColumn(name = "num_profesor")
	private Integer numProfesor;
	private String abreviatura;
	private String nombre;
	private String nivel;
	private Integer codigo;
	
	public Profesor() {
	}
	
	public Profesor(Integer numProfesor, String abreviatura, String nombre, String nivel, Integer codigo) {
		this.numProfesor = numProfesor;
		this.abreviatura = abreviatura;
		this.nombre = nombre;
		this.nivel = nivel;
		this.codigo = codigo;
	}

	public Integer getNumProfesor() {
		return numProfesor;
	}

	public void setNumProfesor(Integer numProfesor) {
		this.numProfesor = numProfesor;
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
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numProfesor == null) ? 0 : numProfesor.hashCode());
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
		Profesor other = (Profesor) obj;
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
		if (numProfesor == null) {
			if (other.numProfesor != null)
				return false;
		} else if (!numProfesor.equals(other.numProfesor))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Profesor [numProfesor=" + numProfesor + ", abreviatura=" + abreviatura + ", nombre=" + nombre
				+ ", nivel=" + nivel + ", codigo=" + codigo + "]";
	}
	
}
