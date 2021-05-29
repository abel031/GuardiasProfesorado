package xmlParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import application.HashEncaoder;
import hibernate.UtilesHibernate;
import pojos.Actividad;
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
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(new FileInputStream(file)));
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
				Usuario u = new Usuario(null, profesor.getAbreviatura().toUpperCase(), HashEncaoder.encode("Isca2021."), 1);
				session.save(u);
				profesor.setUsuario(u);
				session.save(profesor);
			}
			for (Grupo grupo : grupos) {
				for (RelProfeGrupo relProfeGrupo : relsPG) {
					String numGr = relProfeGrupo.getGrupo();
					int numPro = relProfeGrupo.getNumProfe();
					if(grupo.getNumGrupo() == Integer.parseInt(numGr)) {
						for (Profesor profesor : profesores) {
							if(profesor.getNumProfesor() == numPro) {
								grupo.setTutor(profesor);
							}
						}
					}
				}
				session.save(grupo);
			}
			for (Aula aula : aulas) {
				session.save(aula);
			}
			for (TramoHorario tramoHorario : tramosHorarios) {
				session.save(tramoHorario);
			}
			for (RelActividad relActividad : relActividades) {
				Actividad act = new Actividad(relActividad.getNumActividad(), null, null, null, null, null);
				for (Asignatura asignatura : asignaturas) {
					if(asignatura.getNumAsignatura() == relActividad.getNumAsignatura()) {
						act.setAsignatura(asignatura);
					}
				}
				for (Aula aula : aulas) {
					if(aula.getNunAula() == relActividad.getNumAula()) {
						act.setAula(aula);
					}
				}
				for (Profesor profesor : profesores) {
					if(profesor.getNumProfesor() == relActividad.getNumProfesor()) {
						act.setProfesor(profesor);
					}
				}
				for (TramoHorario tramoHorario : tramosHorarios) {
					if(tramoHorario.getNumTramo() == relActividad.getNumTramo()) {
						act.setTramo(tramoHorario);
					}
				}
				
				
				session.save(act);
			}
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
