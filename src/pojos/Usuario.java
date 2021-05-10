package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "usuarios")
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="num_usuario")
	private Integer numUsuario;
	private String usuario;
	private String passwd;
	@Column(name="tipo_usuario")
	private Integer tipoUsuario;
	
	public Usuario() {
	}

	public Usuario(Integer numUsuario, String usuario, String passwd, Integer tipoUsuario) {
		this.numUsuario = numUsuario;
		this.usuario = usuario;
		this.passwd = passwd;
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getNumUsuario() {
		return numUsuario;
	}

	public void setNumUsuario(Integer numUsuario) {
		this.numUsuario = numUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numUsuario == null) ? 0 : numUsuario.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (numUsuario == null) {
			if (other.numUsuario != null)
				return false;
		} else if (!numUsuario.equals(other.numUsuario))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (tipoUsuario == null) {
			if (other.tipoUsuario != null)
				return false;
		} else if (!tipoUsuario.equals(other.tipoUsuario))
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
		return "Usuario [numUsuario=" + numUsuario + ", usuario=" + usuario + ", passwd=" + passwd + ", tipoUsuario="
				+ tipoUsuario + "]";
	}

}
