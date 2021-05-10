package application;
	
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pojos.Usuario;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		
		session.beginTransaction();
		Query q = session.createQuery("SELECT u FROM usuarios u");
		List<Usuario> usuarios = (List<Usuario>)q.list();
		if(usuarios.isEmpty()) {
			String passwd = HashEncaoder.encode("Isca2021.");
			Usuario u = new Usuario(null, "administrador", passwd, 1);
			session.save(u);
		}
		session.getTransaction().commit();
		
		launch(args);
	}
}
