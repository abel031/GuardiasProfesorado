package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import application.HashEncaoder;
import application.Main;
import hibernate.UtilesHibernate;
import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.layout.Pane;
import pojos.Usuario;

public class LoginController implements Initializable{
	
	private Main gestorVentana;
	@FXML
	private PasswordField rawPwd;
	@FXML
	private TextField user;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	// Event Listener on Button.onAction
	@FXML
	public void login(ActionEvent event) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		Query q = session.createQuery("SELECT u FROM usuarios u WHERE usuario LIKE :usr");
		q.setParameter("usr", user.getText());
		List<Usuario> usuarios = (List<Usuario>)q.list();
		session.getTransaction().commit();
		session.close();
		if(usuarios.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usuario Inexistente", "Usuario Inexistente", JOptionPane.ERROR_MESSAGE);
		}else {
			Usuario u = usuarios.get(0);
			String pwd = HashEncaoder.encode(rawPwd.getText());

			if(u.getPasswd().equals(pwd)){
				gestorVentana.setUsuario(u);
				gestorVentana.muestraPrincipal();
			}else {
				JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Contraseña incorecta", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	
	public void setGestorVentanas(Main gestor) {
		this.gestorVentana = gestor;
	}
}
