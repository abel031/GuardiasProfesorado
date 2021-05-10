package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import javafx.event.ActionEvent;

public class TestController {
	@FXML
	private TextField txserver;
	@FXML
	private TextField txdb;

	// Event Listener on Button.onAction
	@FXML
	public void Click(ActionEvent event) {
		UtilesHibernate util = new UtilesHibernate(txserver.getText(), txdb.getText(), "root", "0310");
		util.conectar();
		SessionFactory factory = util.getSessionFactory();
		Session sesion = factory.getCurrentSession();
		sesion.beginTransaction();
		
		sesion.getTransaction().commit();
	}
}
