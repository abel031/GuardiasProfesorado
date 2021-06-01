package application.controller;

import javafx.fxml.FXML;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import application.Main;
import hibernate.UtilesHibernate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;
import pojos.Actividad;
import pojos.Guardia;
import pojos.Profesor;
import pojos.Usuario;
import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;

public class GuardiaController {
	@FXML
	private DatePicker fecha;
	@FXML
	private ChoiceBox<String> hora;
	@FXML
	private ComboBox<String> sustituto;
	@FXML
	private TextArea work;
	
	private Main gestorVentana;
	private Usuario usuario;
	private List<Actividad> actividades;
	private Guardia guardia;
	private List<Profesor> profesores;

	// Event Listener on Button.onAction
	@FXML
	public void saveGuardia(ActionEvent event) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		
		if(gestorVentana.getUsuario().getTipoUsuario() == 0) {
			guardia.setSustituto(profesores.get(sustituto.getSelectionModel().getSelectedIndex()));
			session.update(guardia);
		}else {
		boolean trabajo = true;
		if(work.getText().isBlank()) {
			trabajo = false;
		}
		Guardia g = new Guardia(null, null, actividades.get(hora.getSelectionModel().getSelectedIndex()), trabajo, work.getText(), fecha.getValue());
		session.save(g);
		}
		session.getTransaction().commit();
		session.close();
		gestorVentana.muestraLista();
	}
	
	@FXML
	public void fechaSelect(ActionEvent event) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		Query pro = session.createQuery("SELECT p FROM profesor p WHERE num_usuario = :id");
		pro.setParameter("id", usuario.getNumUsuario());
		Profesor p = (Profesor) pro.getSingleResult();
		Query q = session.createQuery("SELECT a FROM actividad a WHERE num_profesor = :id");
		LocalDate dia = fecha.getValue();
		String diaW = dia.getDayOfWeek().toString();
		if(diaW.equals("MONDAY")) {
			q = session.createQuery("SELECT a FROM actividad a, TramoHorario t WHERE a.tramo = t.numTramo AND num_profesor = :id AND numero_dia = 1");
		}
		if(diaW.equals("TUESDAY")) {
			q = session.createQuery("SELECT a FROM actividad a, TramoHorario t WHERE a.tramo = t.numTramo AND num_profesor = :id AND numero_dia = 2");
		}
		if(diaW.equals("WEDNESDAY")) {
			q = session.createQuery("SELECT a FROM actividad a, TramoHorario t WHERE a.tramo = t.numTramo AND num_profesor = :id AND numero_dia = 3");
		}
		if(diaW.equals("THURSDAY")) {
			q = session.createQuery("SELECT a FROM actividad a, TramoHorario t WHERE a.tramo = t.numTramo AND num_profesor = :id AND numero_dia = 4");
		}
		if(diaW.equals("FRIDAY")) {
			q = session.createQuery("SELECT a FROM actividad a, TramoHorario t WHERE a.tramo = t.numTramo AND num_profesor = :id AND numero_dia = 5");
		}
		q.setParameter("id", p.getNumProfesor());
		actividades = (List<Actividad>)q.list();
		ArrayList<String> sActividades = new ArrayList<>();
		for (Actividad actividad : actividades) {
			sActividades.add(actividad.getAsignatura().getAbreviatura());
		}
		ObservableList<String> OAcividad = FXCollections.observableList(sActividades);
		hora.setItems(OAcividad);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void setGestorVentanas(Main gestor) {
		this.gestorVentana = gestor;
		usuario = gestorVentana.getUsuario();
		if(usuario.getTipoUsuario() != 0) {
			sustituto.setDisable(true);
			SessionFactory SF = UtilesHibernate.getSessionFactory();
			Session session = SF.getCurrentSession();
			
			session.beginTransaction();
			Query pro = session.createQuery("SELECT p FROM profesor p WHERE num_usuario = :id");
			pro.setParameter("id", usuario.getNumUsuario());
			Profesor p = (Profesor) pro.getSingleResult();
			actividades = p.getActividades();
			ArrayList<String> sActividades = new ArrayList<>();
			for (Actividad actividad : actividades) {
				sActividades.add(actividad.getAsignatura().getAbreviatura());
			}
			ObservableList<String> OAcividad = FXCollections.observableList(sActividades);
			hora.setItems(OAcividad);
			session.getTransaction().commit();
			session.close();
		}else {
			fecha.setDisable(true);
			hora.setDisable(true);
			work.setDisable(true);
		}
	}
	
	public void setGuardia(Guardia gaur) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		this.guardia = gaur;
		if(guardia != null) {
			fecha.setValue(guardia.getDia());
			work.setText(guardia.getTrabajoList());
			ArrayList<String> act = new ArrayList<>();
			act.add(guardia.getActividad().getAsignatura().getAbreviatura());
			ObservableList<String> OAcividad = FXCollections.observableList(act);
			hora.setItems(OAcividad);
		}
		Query pro = session.createQuery("SELECT p FROM profesor p");
		profesores = (List<Profesor>)pro.list();
		ArrayList<String> sPro = new ArrayList<>();
		for (Profesor prop : profesores) {
			sPro.add(prop.getNombre());
		}
		ObservableList<String> OProfesor = FXCollections.observableList(sPro);
		sustituto.setItems(OProfesor);
		session.getTransaction().commit();
		session.close();
	}
}
