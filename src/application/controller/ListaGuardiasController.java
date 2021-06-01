package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import application.Main;
import hibernate.UtilesHibernate;
import pojos.Guardia;
import pojos.GuardiasData;
import pojos.Profesor;
import pojos.TablaGuardias;
import pojos.Usuario;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ListaGuardiasController implements Initializable{
	@FXML
	private TableView<GuardiasData> TablaGuardias;
	@FXML
	private TableColumn<Guardia, String> profeSustit;
	@FXML
	private TableColumn<Guardia, LocalTime> hora;
	@FXML
	private TableColumn<Guardia, String> aula;
	@FXML
	private TableColumn<Guardia, LocalDate> dia;
	@FXML
	private TableColumn<Guardia, String> work;
	@FXML
	private Button BtnAsign;
	
	private Main gestorVentana;
	private TablaGuardias tablaGuardia;
	private Guardia guardia;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	// Event Listener on Button.onAction
	@FXML
	public void newGuardia(ActionEvent event) {
		gestorVentana.muestraGuardia();
		gestorVentana.setGuardia(null);
	}
	// Event Listener on Button.onAction
	@FXML
	public void delete(ActionEvent event) {
		GuardiasData ga = TablaGuardias.getSelectionModel().getSelectedItem();
		tablaGuardia.borraFila(ga.getId());
	}
	// Event Listener on Button[#BtnAsign].onAction
	@FXML
	public void asignar(ActionEvent event) {
		gestorVentana.setGuardia(guardia);
		gestorVentana.muestraGuardia();
	}
	
	public void setGestorVentanas(Main gestor) {
		this.gestorVentana = gestor;
		cargaDatos();
		disable();
	}
	
	private void cargaDatos() {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		Usuario u = this.gestorVentana.getUsuario();
		Profesor p;
		if(u.getTipoUsuario() == 0) {
			p = null;
		}else {
			Query pro = session.createQuery("SELECT p FROM profesor p WHERE num_usuario = :id");
			pro.setParameter("id", u.getNumUsuario());
			p = (Profesor) pro.getSingleResult();			
		}
		session.getTransaction().commit();
		session.close();
		this.tablaGuardia = new TablaGuardias(TablaGuardias, p);
		
		profeSustit.setCellValueFactory(new PropertyValueFactory<Guardia, String>("profesor"));
		hora.setCellValueFactory(new PropertyValueFactory<Guardia, LocalTime>("hora"));
		aula.setCellValueFactory(new PropertyValueFactory<Guardia, String>("aula"));
		dia.setCellValueFactory(new PropertyValueFactory<Guardia, LocalDate>("fecha"));
		work.setCellValueFactory(new PropertyValueFactory<Guardia, String>("trabajo"));
		
		TablaGuardias.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> asignGuardia(newValue));
		TablaGuardias.setItems(tablaGuardia.getGuardias());
		
	}
	
	private void disable() {
		Usuario u = this.gestorVentana.getUsuario();
		if(u.getTipoUsuario() != 0) {
			BtnAsign.setDisable(true);
		}
	}
	
	private void asignGuardia(GuardiasData ga) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		Query q = session.createQuery("SELECT g FROM guardia g WHERE numGuardia = :id");
		q.setParameter("id", ga.getId());
		Guardia g = (Guardia)q.getSingleResult();
		this.guardia = g;
		session.getTransaction().commit();
		session.close();
	}
}
