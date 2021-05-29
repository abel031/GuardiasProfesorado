package xmlParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import application.HashEncaoder;
import hibernate.UtilesHibernate;
import pojos.Asignatura;
import pojos.Aula;
import pojos.Grupo;
import pojos.Profesor;
import pojos.RelActividad;
import pojos.RelProfeGrupo;
import pojos.TramoHorario;
import pojos.Usuario;

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
			List<RelActividad> relActividades = handler.GetListaRelActividad();
			for (RelActividad relActividad : relActividades) {
				System.out.println(relActividad);
			}
		
			SessionFactory SF = UtilesHibernate.getSessionFactory();
			Session session = SF.getCurrentSession();
			
			session.beginTransaction();
			for (Asignatura asignatura : asignaturas) {
				session.save(asignatura);
			}
			for (Profesor profesor : profesores) {
				Usuario u = new Usuario(null, profesor.getAbreviatura(), HashEncaoder.encode("Isca2021."), 1);
				session.save(u);
				profesor.setUsuario(u);
				session.save(profesor);
			}
			for (Grupo grupo : grupos) {
				session.save(grupo);
			}
			for (Aula aula : aulas) {
				session.save(aula);
			}
			for (TramoHorario tramoHorario : tramosHorarios) {
				session.save(tramoHorario);
			}
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
