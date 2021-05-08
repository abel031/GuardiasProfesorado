package pojos;

public class RelProfeGrupo {
	
	private Integer numProfe;
	private String grupo;
	
	public RelProfeGrupo(Integer numProfe, String grupo) {
		this.numProfe = numProfe;
		this.grupo = grupo;
	}
	public Integer getNumProfe() {
		return numProfe;
	}
	public void setNumProfe(Integer numProfe) {
		this.numProfe = numProfe;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	@Override
	public String toString() {
		return "RelProfeGrupo [numProfe=" + numProfe + ", grupo=" + grupo + "]";
	}

}
