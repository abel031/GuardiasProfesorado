package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pojos.Usuario;
import xmlParser.parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

public class OptionsController implements Initializable{
	@FXML
	private TextField file;
	@FXML
	private PasswordField TFActualPwd;
	@FXML
	private PasswordField TFNewPwd;
	@FXML
	private Button BtnSelec;
	@FXML
	private Button BtnParse;
	
	private FileChooser fc = new FileChooser();
	private File selec;
	private Main gestorVentanas;
	private Usuario usuario;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void selectFile(ActionEvent event) {
		fc.setTitle("Selecconar archivo");
		selec = fc.showOpenDialog(null);
		if(selec != null) {
			file.setText(selec.getAbsolutePath());
			
		}else {
			JOptionPane.showMessageDialog(null, "sin archivo seleccionado");
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void parse(ActionEvent event) {
		parser.parse(selec);
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void ChangePwd(ActionEvent event) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		String newPwd = HashEncaoder.encode(TFNewPwd.getText());
		String actPwd = HashEncaoder.encode(TFActualPwd.getText());
		if(usuario.getPasswd().equals(actPwd)) {
			usuario.setPasswd(newPwd);
			session.update(usuario);
		}
		session.getTransaction().commit();
		session.close();
		gestorVentanas.closeOptions();
		
	}
	
	public void setGestorVentanas(Main gestor) {
		this.gestorVentanas = gestor;
		usuario = gestorVentanas.getUsuario();
		if(usuario.getTipoUsuario() != 0) {
			file.setDisable(true);
			BtnParse.setDisable(true);
			BtnSelec.setDisable(true);
		}
	}
}
