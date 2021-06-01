package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name = "profesor")
public class Profesor implements Serializable{
	
	@Id
	@Column(name = "num_profesor")
	private Integer numProfesor;
	private String abreviatura;
	private String nombre;
	private String nivel;
	private String codigo;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="num_usuario")
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profesor")
	private List<Actividad> actividades;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "sustituto")
	private List<Guardia> guardias;
	
	public Profesor() {
	}

	public Profesor(Integer numProfesor, String abreviatura, String nombre, String nivel, String codigo,
			Usuario usuario, List<Actividad> actividades) {
		this.numProfesor = numProfesor;
		this.abreviatura = abreviatura;
		this.nombre = nombre;
		this.nivel = nivel;
		this.codigo = codigo;
		this.usuario = usuario;
		this.actividades = actividades;
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
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public List<Guardia> getGuardias() {
		return guardias;
	}

	public void setGuardias(List<Guardia> guardias) {
		this.guardias = guardias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + ((actividades == null) ? 0 : actividades.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((guardias == null) ? 0 : guardias.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numProfesor == null) ? 0 : numProfesor.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (actividades == null) {
			if (other.actividades != null)
				return false;
		} else if (!actividades.equals(other.actividades))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (guardias == null) {
			if (other.guardias != null)
				return false;
		} else if (!guardias.equals(other.guardias))
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [numProfesor=" + numProfesor + ", abreviatura=" + abreviatura + ", nombre=" + nombre
				+ ", nivel=" + nivel + ", codigo=" + codigo + "]";
	}
	
}
