package application;
	
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import application.controller.GuardiaController;
import application.controller.ListaGuardiasController;
import application.controller.LoginController;
import application.controller.MainViewController;
import application.controller.OptionsController;
import hibernate.UtilesHibernate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pojos.Usuario;
import pojos.Guardia;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage LoginStage;
	private Stage OptionsStage;
	private Stage MainView;
	private Stage Guardia;
	private Stage ListaGuardia;
	private Usuario user;
	private Guardia gaurdia;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.LoginStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((getClass().getResource("view/Login.fxml")));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LoginStage.setScene(scene);
			LoginStage.setTitle("Login");
			LoginController controller = loader.getController();
			controller.setGestorVentanas(this);
			LoginStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void muestraLogin(){
        
        try{
            this.LoginStage = new Stage();

            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("view/Login.fxml"));

            BorderPane borde = (BorderPane) loader.load();
            Scene scene = new Scene(borde);
            this.LoginStage.setTitle("Login");
            this.LoginStage.setScene(scene);
            LoginController controler = loader.getController();
            controler.setGestorVentanas(this);
            
            if(this.MainView != null) {
            	this.MainView.close();
            }

            this.LoginStage.show();
        }catch(IOException ioe){
            ioe.printStackTrace();
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
	            controler.setGestorVentanas(this);
	
	            this.OptionsStage.show();
	        }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
    }
	
	public void muestraGuardia() {
		try{
            this.Guardia = new Stage();

            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("view/GuardiaView.fxml"));

            BorderPane borde = (BorderPane) loader.load();
            Scene scene = new Scene(borde);
            this.Guardia.setTitle("Lista Guardias");
            this.Guardia.setScene(scene);
            GuardiaController controler = loader.getController();
            controler.setGestorVentanas(this);
            controler.setGuardia(gaurdia);
            
            if(ListaGuardia != null) {
            	ListaGuardia.close();
            }
            
            this.Guardia.show();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
	}
	
	public void muestraPrincipal() {
		try{
            this.MainView = new Stage();

            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("view/MainView.fxml"));

            BorderPane borde = (BorderPane) loader.load();
            Scene scene = new Scene(borde);
            this.MainView.setTitle("Guardias");
            this.MainView.setScene(scene);
            MainViewController controler = loader.getController();
            controler.setGestorVentanas(this);
            
            if(this.LoginStage != null) {
            	this.LoginStage.close();
            }
            if(this.OptionsStage != null) {
            	this.OptionsStage.close();
            }
            
            this.MainView.show();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
	}
	
	public void muestraLista() {
		try{
            this.ListaGuardia = new Stage();

            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("view/ListaGuardiasView.fxml"));

            BorderPane borde = (BorderPane) loader.load();
            Scene scene = new Scene(borde);
            this.ListaGuardia.setTitle("Guardias");
            this.ListaGuardia.setScene(scene);
            ListaGuardiasController controler = loader.getController();
            controler.setGestorVentanas(this);
            
            if(Guardia != null) {
            	Guardia.close();
            }
            
            this.ListaGuardia.show();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
	}
	
	public void closeOptions() {
		this.OptionsStage.close();
	}
	
	public void setUsuario(Usuario usr) {
		this.user = usr;
	}
	
	public Usuario getUsuario() {
		return this.user;
	}
	
	public void setGuardia(Guardia guar) {
		this.gaurdia = guar;
	}
	
	public Guardia getGuardia() {
		return gaurdia;
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
		session.close();
		
		launch(args);
	}
}
