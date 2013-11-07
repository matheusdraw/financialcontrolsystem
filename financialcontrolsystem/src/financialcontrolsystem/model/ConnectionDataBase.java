package financialcontrolsystem.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDataBase {

	protected static EntityManager manager = null;
	protected static EntityManagerFactory factory = null;
	
	public static EntityManager getConnection(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("financialdb");
		return manager = factory.createEntityManager();
	}	
}
