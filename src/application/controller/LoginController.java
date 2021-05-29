package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.layout.Pane;

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
		gestorVentana.muestraOptions();
	}
	
	public void setGestorVentanas(Main gestor) {
		this.gestorVentana = gestor;
	}
}
