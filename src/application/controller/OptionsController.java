package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import xmlParser.parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

public class OptionsController {
	@FXML
	private TextField file;
	
	FileChooser fc = new FileChooser();
	File selec;

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
}
