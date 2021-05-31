package xmlParser;


import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pojos.Asignatura;
import pojos.Aula;
import pojos.Grupo;
import pojos.Profesor;
import pojos.RelActividad;
import pojos.RelProfeGrupo;
import pojos.TramoHorario;

public class XmlHandler extends DefaultHandler{
	
	//Common
	private boolean abre, nom, lv, code;
	private String abreviatura, nombre, nivel, codigo;
	
	//Asignatura
	private boolean asignaturas, asignatura, course;
	private String curso;
	private Integer numAsignatura;
	private Asignatura asig;
	private ArrayList<Asignatura> asigs = new ArrayList<Asignatura>();
	
	//Grupo
	private boolean grupos, grupo;
	private Integer numGrupo;
	private Grupo group;
	private ArrayList<Grupo> groups = new ArrayList<Grupo>();
	
	//Aula
	private boolean aulas, aula;
	private Integer numAula;
	private Aula classroom;
	private ArrayList<Aula> classrooms = new ArrayList<Aula>();
	
	//Profesor
	private boolean profes, profe, ngru;
	private Integer numProfesor;
	private String nGrupo;
	private Profesor profesor;
	private ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	private RelProfeGrupo relPG;
	private ArrayList<RelProfeGrupo> relsPG = new ArrayList<RelProfeGrupo>();
	
	//TramoHorario
	private boolean tramos, tramo, numDia, numH, hInicio, hFinal;
	private Integer numTramoHorario, nDia, nHora;
	private LocalTime horaI, horaF;
	private TramoHorario tramoHora;
	private ArrayList<TramoHorario> tramosHorarios = new ArrayList<TramoHorario>();
	
	//Actividad
	private boolean pros, pro, act, tra, asign, aul, ga, gru;
	private Integer numActividad, nProfe, nTramo, nAsig, nAula, nGru, numUn;
	private ArrayList<Integer> grus = new ArrayList<Integer>();
	private RelActividad relAct;
	private ArrayList<RelActividad> relActs = new ArrayList<RelActividad>();
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio del Analisis");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End of Document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//Asignatura
		if(qName.equals("ASIGNATURAS")) asignaturas = true;
		if(qName.equals("ASIGNATURA") && asignaturas) {
			asignatura = true;
			numAsignatura = Integer.parseInt(attributes.getValue(0));
		}
		if(asignatura) {
			if(qName.equals("ABREVIATURA")) abre = true;
			if(qName.equals("NOMBRE"))nom = true;
			if(qName.equals("NIVEL")) lv = true;
			if(qName.equals("CODIGO")) code = true;
			if(qName.equals("CURSO")) course = true;
		}
		
		//Grupo
		if(qName.equals("GRUPOS")) grupos = true;
		if(qName.equals("GRUPO") && grupos) {
			grupo = true;
			numGrupo = Integer.parseInt(attributes.getValue(0));
		}
		if(grupo) {
			if(qName.equals("ABREVIATURA")) abre = true;
			if(qName.equals("NOMBRE")) nom = true;
			if(qName.equals("CODIGO")) code  =true;
		}
		
		//Aula
		if(qName.equals("AULAS")) aulas = true;
		if(qName.equals("AULA") && aulas) {
			aula = true;
			numAula = Integer.parseInt(attributes.getValue(0));
		}
		if(aula) {
			if(qName.equals("ABREVIATURA")) abre = true;
			if(qName.equals("NOMBRE")) nom = true;
			if(qName.equals("NIVEL")) lv = true;
			if(qName.equals("CODIGO")) code = true;
		}
		
		//Profesor
		if(qName.equals("PROFESORES")) profes = true;
		if(qName.equals("PROFESOR") && profes) {
			profe = true;
			numProfesor = Integer.parseInt(attributes.getValue(0));
		}
		if(profe) {
			if(qName.equals("ABREVIATURA")) abre = true;
			if(qName.equals("NOMBRE")) nom = true;
			if(qName.equals("NIVEL")) lv = true;
			if(qName.equals("CODIGO")) code = true;
			if(qName.equals("NUM_GR_TUTORIA_PRINCIPAL")) ngru = true;
		}
		
		//TramoHorario
		if(qName.equals("TRAMOS_HORARIOS")) tramos = true;
		if(qName.equals("TRAMO") && tramos) {
			tramo = true;
			numTramoHorario = Integer.parseInt(attributes.getValue(0));
		}
		if(tramo) {
			if(qName.equals("CODIGO")) code = true;
			if(qName.equals("NUMERO_DIA")) numDia = true;
			if(qName.equals("NUMERO_HORA")) numH = true;
			if(qName.equals("HORA_INICIO")) hInicio = true;
			if(qName.equals("HORA_FINAL")) hFinal = true;			
		}
		
		//Actividad
		if(qName.equals("HORARIOS_PROFESORES")) pros = true;
		if(pros) {
			if(qName.equals("HORARIO_PROF")) {
				pro = true;
				nProfe = Integer.parseInt(attributes.getValue(0));
			}
			if(pro) {
				if(qName.equals("ACTIVIDAD")) {
					act = true;
					numUn = Integer.parseInt(attributes.getValue(1));
					numActividad = Integer.parseInt(attributes.getValue(0));
				}
				if(act) {
					if(qName.equals("TRAMO")) tra = true;
					if(qName.equals("ASIGNATURA")) asign = true;
					if(qName.equals("AULA")) aul = true;
					if(qName.equals("GRUPOS_ACTIVIDAD")) ga =true;
					if(ga) {
						if(qName.equals("GRUPO")) gru = true;
					}
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//Asignatura
		if(qName.equals("ASIGNATURAS")) asignaturas = false;
		if(qName.equals("ASIGNATURA") && asignaturas) {
			asignatura = false;
			asig = new Asignatura(numAsignatura, abreviatura, nombre, nivel, codigo, curso, null);
			asigs.add(asig);
		}
		if(asignatura) {
			if(qName.equals("ABREVIATURA")) abre = false;
			if(qName.equals("NOMBRE"))nom = false;
			if(qName.equals("NIVEL")) lv = false;
			if(qName.equals("CODIGO")) code = false;
			if(qName.equals("CURSO")) course = false;
		}
		
		//Grupo
		if(qName.equals("GRUPOS")) grupos = false;
		if(qName.equals("GRUPO") && grupos) {
			grupo = false;
			group = new Grupo(numGrupo, abreviatura, nombre, codigo, null, null);
			groups.add(group);
		}
		if(grupo) {
			if(qName.equals("ABREVIATURA")) abre = false;
			if(qName.equals("NOMBRE")) nom = false;
			if(qName.equals("CODIGO")) code  =false;
		}
		
		//Aula
		if(qName.equals("AULAS")) aulas = false;
		if(qName.equals("AULA") && aulas) {
			aula = false;
			classroom = new Aula(numAula, abreviatura, nombre, null, null, null);
			classrooms.add(classroom);
		}
		if(aula) {
			if(qName.equals("ABREVIATURA")) abre = false;
			if(qName.equals("NOMBRE")) nom = false;
			if(qName.equals("NIVEL")) lv = false;
			if(qName.equals("CODIGO")) code = false;
		}
		
		//Profesor
		if(qName.equals("PROFESORES")) profes = false;
		if(qName.equals("PROFESOR") && profes) {
			profe = false;
			profesor = new Profesor(numProfesor, abreviatura, nombre, nivel, codigo, null, null);
			profesores.add(profesor);
			relPG = new RelProfeGrupo(numProfesor, nGrupo);
			relsPG.add(relPG);
		}
		if(profe) {
			if(qName.equals("ABREVIATURA")) abre = false;
			if(qName.equals("NOMBRE")) nom = false;
			if(qName.equals("NIVEL")) lv = false;
			if(qName.equals("CODIGO")) code = false;
			if(qName.equals("NUM_GR_TUTORIA_PRINCIPAL")) ngru = false;
		}
			
		//TramoHorario
		if(qName.equals("TRAMOS_HORARIOS")) tramos = false;
		if(qName.equals("TRAMO") && tramos) {
			tramo = false;
			tramoHora = new TramoHorario(numTramoHorario, Integer.parseInt(codigo), nDia, nHora, horaI, horaF, null);
			tramosHorarios.add(tramoHora);
		}
		if(tramo) {
			if(qName.equals("CODIGO")) code = false;
			if(qName.equals("NUMERO_DIA")) numDia = false;
			if(qName.equals("NUMERO_HORA")) numH = false;
			if(qName.equals("HORA_INICIO")) hInicio = false;
			if(qName.equals("HORA_FINAL")) hFinal = false;			
		}
		
		//Actividad
		if(qName.equals("HORARIOS_PROFESORES")) pros = false;
		if(pros) {
			if(qName.equals("HORARIO_PROF")) {
				pro = false;
			}
			if(pro) {
				if(qName.equals("ACTIVIDAD")) {
					act = false;
					relAct = new RelActividad(numActividad, nTramo, nAula, nAsig, nProfe, numUn, grus);
					relActs.add(relAct);
					grus = new ArrayList<Integer>();
				}
				if(act) {
					if(qName.equals("TRAMO")) tra = false;
					if(qName.equals("ASIGNATURA")) asign = false;
					if(qName.equals("AULA")) aul = false;
					if(qName.equals("GRUPOS_ACTIVIDAD")) {
						ga =false;
					}
					if(ga) {
						if(qName.equals("GRUPO")) {
							gru = false;
							grus.add(nGru);
						}
					}
				}
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//Asignatura
		if(asignatura) {
			if(abre) abreviatura = new String(ch,start,length);
			if(nom) nombre = new String(ch,start,length);
			if(lv) nivel = new String(ch,start,length);
			if(code) codigo = new String(ch,start,length);
			if(course) curso = new String(ch,start,length);
		}
		
		//Grupo
		if(grupo) {
			if(abre) abreviatura = new String(ch,start,length);
			if(nom) nombre = new String(ch,start,length);
			if(code) codigo = new String(ch,start,length);
		}
		
		//Aula
		if(aula) {
			if(abre) abreviatura = new String(ch,start,length);
			if(nom) nombre = new String(ch,start,length);
			if(lv) nivel = new String(ch,start,length);
			if(code) codigo = new String(ch,start,length);
		}
		
		//Profesor
		if(profe) {
			if(abre) abreviatura = new String(ch,start,length);
			if(nom) nombre = new String(ch,start,length);
			if(lv) nivel = new String(ch,start,length);
			if(code) codigo = new String(ch,start,length);
			if(ngru) nGrupo = new String(ch,start,length);
		}
		
		//TramoHorario
		if(tramo) {
			if(code) codigo = new String(ch,start,length);
			if(numDia) nDia = Integer.parseInt(new String(ch,start,length));
			if(numH) nHora = Integer.parseInt(new String(ch,start,length));
			if(hInicio) horaI = timeTransformer(new String(ch,start,length));
			if(hFinal) horaF = timeTransformer(new String(ch,start,length));
		}
		
		//Actividad
		if(pros) {
			if(pro) {
				if(act) {
					if(tra) nTramo = Integer.parseInt(new String(ch,start,length));
					if(asign) nAsig = Integer.parseInt(new String(ch,start,length));
					if(aul) nAula = Integer.parseInt(new String(ch,start,length));
					if(ga) {
						if(gru) {
							nGru =  Integer.parseInt(new String(ch,start,length));
						}
						
					}
				}
			}
		}
	}
	
	private LocalTime timeTransformer(String time) {
		try {
				String tf = time.replace(' ', '0');
			LocalTime hora = LocalTime.parse(tf);
			return hora;
		} catch(Exception e) {
		    e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Asignatura> GetListaAsignaturas() {
		return asigs;
	}
	
	public ArrayList<Grupo> GetListaGrupos() {
		return groups;
	}
	
	public ArrayList<Aula> GetListaAulas() {
		return classrooms;
	}
	
	public ArrayList<Profesor> GetListaProfesores() {
		return profesores;
	}
	
	public ArrayList<RelProfeGrupo> GetListaRelProfeGrupo() {
		return relsPG;
	}
	
	public ArrayList<TramoHorario> GetListaRelTramoHorario() {
		return tramosHorarios;
	}
	
	public ArrayList<RelActividad> GetListaRelActividad() {
		return relActs;
	}
}
