package xmlParser;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import pojos.Asignatura;
import pojos.Aula;
import pojos.Grupo;
import pojos.Profesor;
import pojos.RelActividad;
import pojos.RelProfeGrupo;
import pojos.TramoHorario;

public class ParserTest {

	public static void main(String[] args) throws SAXException, IOException {
		XmlHandler handler = new XmlHandler();
		XMLReader p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(handler);
		p.parse("datos.xml");
		List<Asignatura> asignaturas = handler.GetListaAsignaturas();
		for (Asignatura asignatura : asignaturas) {
			System.out.println(asignatura);
		}
		List<Grupo> grupos = handler.GetListaGrupos();
		for (Grupo grupo : grupos) {
			System.out.println(grupo);
		}
		List<Aula> aulas = handler.GetListaAulas();
		for (Aula aula : aulas) {
			System.out.println(aula);
		}
		List<Profesor> profesores = handler.GetListaProfesores();
		for (Profesor profesor : profesores) {
			System.out.println(profesor);
		}
		List<RelProfeGrupo> relsPG = handler.GetListaRelProfeGrupo();
		for (RelProfeGrupo relProfeGrupo : relsPG) {
			System.out.println(relProfeGrupo);
		}
		List<TramoHorario> tramosHorarios = handler.GetListaRelTramoHorario();
		for (TramoHorario tramoHorario : tramosHorarios) {
			System.out.println(tramoHorario);
		}
		List<RelActividad> relActividades = handler.GetListaRelActividad();
		for (RelActividad relActividad : relActividades) {
			System.out.println(relActividad);
		}
	}

}
