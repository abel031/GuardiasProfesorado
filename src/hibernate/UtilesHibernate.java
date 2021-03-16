package hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojos.Equipo;

public class UtilesHibernate {
	
	private static SessionFactory SF;
	
	private String host, databaseName, usr, pwd;
	

	public UtilesHibernate(String host, String databaseName, String usr, String pwd) {
		this.host = host;
		this.databaseName = databaseName;
		this.usr = usr;
		this.pwd = pwd;
	}
	
	public UtilesHibernate() {
	}

	static {
		try {
			Configuration configuration = new Configuration().configure();
			/*StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
			applySettings(configuration.getProperties());*/
			SF = configuration.configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Initial SessionFactory cration failed."+e);
			throw new ExceptionInInitializerError(e);
		}
	}

	private void conectar(String host,String db,String usr,String pwd) {
	    Configuration config = new Configuration();
	    config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	    config.setProperty("hibernate.connection.url", "jdbc:mysql://"+ host +":3306/" + db);
	    config.setProperty("hibernate.connection.username", usr);
	    config.setProperty("hibernate.connection.password", pwd);
	    config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    config.setProperty("hibernate.current_session_context_class", "thread");
	    config.setProperty("hibernate.cache.provider_class", "org.hivernate.cache.NoCacheProvider");
	    config.setProperty("hibernate.show_sql", "true");
	    
	     
	    config.addAnnotatedClass(Equipo.class);
	 
	    SF = config.buildSessionFactory();
	}
	
	public void conectar() {
		conectar(host, databaseName, usr, pwd);
	}
	
	public static SessionFactory getSessionFactory() {
        return SF;
    }
	
}
