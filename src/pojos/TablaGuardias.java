package pojos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class TablaGuardias {
	
	private ObservableList<GuardiasData> listaGuardias = FXCollections.observableArrayList();
	private TableView<GuardiasData> tablaGuardia;
	
	public TablaGuardias(TableView<GuardiasData> tablaGuardia, Profesor p) {
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT g FROM guardia g");
		if(p == null) {
			 q = session.createQuery("SELECT g FROM guardia g");
		}else {
			q = session.createQuery("SELECT g FROM guardia g, actividad a WHERE g.actividad = a.Id AND num_profesor = :id");
			q.setParameter("id", p.getNumProfesor());	
		}
		List<Guardia> guardias = (List<Guardia>)q.list();
		for (Guardia guardia : guardias) {
			String pr = "";
			if(guardia.getSustituto() != null) {
				pr = guardia.getSustituto().getNombre();
			}
			GuardiasData gd = new GuardiasData(pr, guardia.getActividad().getTramo().getHoraInicio(), guardia.getDia(), guardia.getTrabajoList(), guardia.getNumGuardia(), guardia.getActividad().getAula().getAbreviatura());
			this.listaGuardias.add(gd);
		}
		this.tablaGuardia = tablaGuardia;
		session.getTransaction().commit();
		session.close();
	}
	
	public ObservableList<GuardiasData> getGuardias(){
        return listaGuardias;
    }
	
	public void borraFila(int IdGuardia){
        int selected = tablaGuardia.getSelectionModel().getSelectedIndex();
        if (selected >= 0) {
                int id = IdGuardia; 
                SessionFactory SF = UtilesHibernate.getSessionFactory();
        		Session session = SF.getCurrentSession();
        		
        		session.beginTransaction();
        		Query q = session.createQuery("DELETE FROM guardia g WHERE num_guardia = :id");
        		q.setParameter("id", id);
        		q.executeUpdate();
        		session.getTransaction().commit();
        		session.close();
                tablaGuardia.getItems().remove(selected);
            } else {
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);           
                alert.setTitle("Seleccion");
                alert.setHeaderText("Ninguna guardia seleccionada");
                alert.setContentText("Selecciona una guardia de la tabla");
                alert.showAndWait();
            }
    }
	
	public void anyadeFila(Guardia guar){
		SessionFactory SF = UtilesHibernate.getSessionFactory();
		Session session = SF.getCurrentSession();
		session.save(guar);
		GuardiasData gd = new GuardiasData(guar.getSustituto().getNombre(), guar.getActividad().getTramo().getHoraInicio(), guar.getDia(), guar.getTrabajoList(), guar.getNumGuardia(),guar.getActividad().getAula().getAbreviatura());
		listaGuardias.add(gd);
		session.getTransaction().commit();
		session.close();
    }
	

}
