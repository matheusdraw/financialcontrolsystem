package financialcontrolsystem.model;

import javax.persistence.EntityManager;

public class AccountDAO {
	
	private EntityManager manager = ConnectionDataBase.getConnection();

	public boolean create(Account acc) {
		try {
			manager.getTransaction().begin();
			manager.persist(acc);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Account account) {
		try {
			manager.getTransaction().begin();
			manager.merge(account);
			manager.getTransaction().commit();
			manager.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
			return false;
		}
	}
}
