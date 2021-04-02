package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Aula implements Serializable{
	
	@Id
	@JoinColumn(name ="num_aula")
	private Integer nunAula;
	private String abreviatura;
	private String nombre;
	private Integer nivel;
	private String codigo;
	private List<Actividad> actividades;
	
	public Aula() {
	}

	public Aula(Integer nunAula, String abreviatura, String nombre, Integer nivel, String codigo,
			List<Actividad> actividades) {
		this.nunAula = nunAula;
		this.abreviatura = abreviatura;
		this.nombre = nombre;
		this.nivel = nivel;
		this.codigo = codigo;
		this.actividades = actividades;
	}

	public Integer getNunAula() {
		return nunAula;
	}

	public void setNunAula(Integer nunAula) {
		this.nunAula = nunAula;
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

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nunAula == null) ? 0 : nunAula.hashCode());
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
		Aula other = (Aula) obj;
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
		if (nunAula == null) {
			if (other.nunAula != null)
				return false;
		} else if (!nunAula.equals(other.nunAula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aula [nunAula=" + nunAula + ", abreviatura=" + abreviatura + ", nombre=" + nombre + ", nivel=" + nivel
				+ ", codigo=" + codigo + "]";
	}
	
}
