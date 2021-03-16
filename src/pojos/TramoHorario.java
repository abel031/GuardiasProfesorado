package pojos;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tramo_horario")
public class TramoHorario implements Serializable{
	
	@Id
	@JoinColumn(name="num_tramo")
	private Integer numTramo;
	private Integer codigo;
	@JoinColumn(name="numero_dia")
	private Integer numeroDia;
	@JoinColumn(name="numero_hora")
	private Integer numeroHora;
	@JoinColumn(name="hora_inicio")
	private Time horaInicio;
	@JoinColumn(name="hora_final")
	private Time horaFinal;
	
	public TramoHorario() {
	}

	public TramoHorario(Integer numTramo, Integer codigo, Integer numeroDia, Integer numeroHora, Time horaInicio,
			Time horaFinal) {
		this.numTramo = numTramo;
		this.codigo = codigo;
		this.numeroDia = numeroDia;
		this.numeroHora = numeroHora;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}

	public Integer getNumTramo() {
		return numTramo;
	}

	public void setNumTramo(Integer numTramo) {
		this.numTramo = numTramo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroDia() {
		return numeroDia;
	}

	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}

	public Integer getNumeroHora() {
		return numeroHora;
	}

	public void setNumeroHora(Integer numeroHora) {
		this.numeroHora = numeroHora;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((horaFinal == null) ? 0 : horaFinal.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		result = prime * result + ((numTramo == null) ? 0 : numTramo.hashCode());
		result = prime * result + ((numeroDia == null) ? 0 : numeroDia.hashCode());
		result = prime * result + ((numeroHora == null) ? 0 : numeroHora.hashCode());
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
		TramoHorario other = (TramoHorario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (horaFinal == null) {
			if (other.horaFinal != null)
				return false;
		} else if (!horaFinal.equals(other.horaFinal))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		if (numTramo == null) {
			if (other.numTramo != null)
				return false;
		} else if (!numTramo.equals(other.numTramo))
			return false;
		if (numeroDia == null) {
			if (other.numeroDia != null)
				return false;
		} else if (!numeroDia.equals(other.numeroDia))
			return false;
		if (numeroHora == null) {
			if (other.numeroHora != null)
				return false;
		} else if (!numeroHora.equals(other.numeroHora))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TramoHorario [numTramo=" + numTramo + ", codigo=" + codigo + ", numeroDia=" + numeroDia
				+ ", numeroHora=" + numeroHora + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + "]";
	}
	
	
	

}
