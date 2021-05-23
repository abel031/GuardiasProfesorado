package xmlParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import pojos.Asignatura;
import pojos.Aula;
import pojos.Grupo;
import pojos.Profesor;
import pojos.RelProfeGrupo;
import pojos.TramoHorario;

public class parser {
	
	public static void parse(File file) {
		try {
		XmlHandler handler = new XmlHandler();
		XMLReader p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(handler);
		p.parse(new InputSource(new FileInputStream(file)));
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
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
