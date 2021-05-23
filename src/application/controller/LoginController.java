package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import application.Main;
import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.layout.Pane;

public class LoginController {
	
	private Main gestorVentana;
	@FXML
	private PasswordField rawPwd;
	@FXML
	private TextField user;

	// Event Listener on Button.onAction
	@FXML
	public void login(ActionEvent event) {
		gestorVentana.muestraOptions();
	}
	
	public void setGestorVentanas(Main gestor) {
		this.gestorVentana = gestor;
	}
}
