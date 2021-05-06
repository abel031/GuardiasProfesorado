package xmlParser;


import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pojos.Asignatura;
import pojos.Grupo;

public class XmlHandler extends DefaultHandler{
	
	private boolean abre, nom,code;
	private String abreviatura, nombre, codigo;
	
	private boolean asignaturas, asignatura, lv, course;
	private String  nivel, curso;
	private Integer numAsignatura;
	private Asignatura asig;
	private ArrayList<Asignatura> asigs = new ArrayList<Asignatura>();
	
	private boolean grupos, grupo;
	private Integer numGrupo;
	private Grupo group;
	private ArrayList<Grupo> groups = new ArrayList<Grupo>();

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
		
		if(qName.equals("GRUPOS")) grupos = true;
		if(qName.equals("GRUPO") && grupos) {
			grupo = true;
			numGrupo = Integer.parseInt(attributes.getValue(0));
		}
		if(grupo) {
			
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
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
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(abre) abreviatura = new String(ch,start,length);
		if(nom) nombre = new String(ch,start,length);
		if(lv) nivel = new String(ch,start,length);
		if(code) codigo = new String(ch,start,length);
		if(course) curso = new String(ch,start,length);
	}
	
	public ArrayList<Asignatura> GetListaAsignaturas() {
		return asigs;
	}
	
}
