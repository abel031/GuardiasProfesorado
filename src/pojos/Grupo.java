package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Grupo implements Serializable{
	
	@Id
	@JoinColumn(name = "num_grupo")
	private Integer numGrupo;
	private String abreviatura;
	private String nombre;
	private String codigo;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="num_tutor")
	private Profesor tutor;
	
	public Grupo() {
	}
	
	public Grupo(Integer numGrupo, String abreviatura, String nombre, String codigo, Profesor tutor) {
		this.numGrupo = numGrupo;
		this.abreviatura = abreviatura;
		this.nombre = nombre;
		this.codigo = codigo;
		this.tutor = tutor;
	}

	
	public Integer getNumGrupo() {
		return numGrupo;
	}

	public void setNumGrupo(Integer numGrupo) {
		this.numGrupo = numGrupo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Profesor getTutor() {
		return tutor;
	}

	public void setTutor(Profesor tutor) {
		this.tutor = tutor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numGrupo == null) ? 0 : numGrupo.hashCode());
		result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
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
		Grupo other = (Grupo) obj;
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numGrupo == null) {
			if (other.numGrupo != null)
				return false;
		} else if (!numGrupo.equals(other.numGrupo))
			return false;
		if (tutor == null) {
			if (other.tutor != null)
				return false;
		} else if (!tutor.equals(other.tutor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [numGrupo=" + numGrupo + ", abreviatura=" + abreviatura + ", nombre=" + nombre + ", codigo="
				+ codigo + ", tutor=" + tutor + "]";
	}

}
