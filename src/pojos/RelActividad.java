package pojos;

import java.util.List;

public class RelActividad {

	private int numActividad;
	private int numTramo;
	private int numAula;
	private int numAsignatura;
	private int numProfesor;
	private List<Integer> grupos;
	public RelActividad(int numActividad, int numTramo, int numAula, int numAsignatura, int numProfesor,
			List<Integer> grupos) {
		this.numActividad = numActividad;
		this.numTramo = numTramo;
		this.numAula = numAula;
		this.numAsignatura = numAsignatura;
		this.numProfesor = numProfesor;
		this.grupos = grupos;
	}
	public int getNumActividad() {
		return numActividad;
	}
	public void setNumActividad(int numActividad) {
		this.numActividad = numActividad;
	}
	public int getNumTramo() {
		return numTramo;
	}
	public void setNumTramo(int numTramo) {
		this.numTramo = numTramo;
	}
	public int getNumAula() {
		return numAula;
	}
	public void setNumAula(int numAula) {
		this.numAula = numAula;
	}
	public int getNumAsignatura() {
		return numAsignatura;
	}
	public void setNumAsignatura(int numAsignatura) {
		this.numAsignatura = numAsignatura;
	}
	public int getNumProfesor() {
		return numProfesor;
	}
	public void setNumProfesor(int numProfesor) {
		this.numProfesor = numProfesor;
	}
	public List<Integer> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Integer> grupos) {
		this.grupos = grupos;
	}
	@Override
	public String toString() {
		return "RelActividad [numActividad=" + numActividad + ", numTramo=" + numTramo + ", numAula=" + numAula
				+ ", numAsignatura=" + numAsignatura + ", numProfesor=" + numProfesor + ", grupos=" + grupos + "]";
	}
	

}
