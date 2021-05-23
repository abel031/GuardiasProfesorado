package application;
	
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import application.controller.LoginController;
import application.controller.OptionsController;
import hibernate.UtilesHibernate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pojos.Usuario;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage LoginStage;
	private Stage OptionsStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((getClass().getResource("view/Login.fxml")));
			Parent root = loader.load();
			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			LoginController controller = loader.getController();
			controller.setGestorVentanas(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void muestraOptions(){
        
        try{
            this.OptionsStage = new Stage();

            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("view/Options.fxml"));

            BorderPane borde = (BorderPane) loader.load();
            Scene scene = new Scene(borde);
            this.OptionsStage.setTitle("Options");
            this.OptionsStage.setScene(scene);
            OptionsController controler = loader.getController();

            this.OptionsStage.show();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		Query q = session.createQuery("SELECT u FROM usuarios u WHERE usuario LIKE 'administrador'");
		List<Usuario> admin = (List<Usuario>)q.list();
		if(admin.isEmpty()) {
			String passwd = HashEncaoder.encode("Isca2021.");
			Usuario u = new Usuario(null, "administrador", passwd, 0);
			session.save(u);
		}
		Query q1 = session.createQuery("SELECT u FROM usuarios u WHERE usuario LIKE 'vista'");
		List<Usuario> vista = (List<Usuario>)q1.list();
		if(vista.isEmpty()) {
			String passwd = HashEncaoder.encode("Isca2021.");
			Usuario us = new Usuario(null,"vista",passwd, 2);
			session.save(us);
		}
		session.getTransaction().commit();
		
		launch(args);
	}
}
