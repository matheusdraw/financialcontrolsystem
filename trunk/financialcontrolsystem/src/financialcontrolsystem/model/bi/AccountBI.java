package financialcontrolsystem.model.bi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import financialcontrolsystem.model.Account;
import financialcontrolsystem.model.AccountType;
import financialcontrolsystem.model.ConnectionDataBase;

public class AccountBI {
	
	private EntityManager manager = ConnectionDataBase.getConnection();
	
	public List<AccountType> listTypes() {
		try {
			Query query = manager.createQuery("SELECT t FROM AccountType t");
			List<AccountType> accTypes = query.getResultList();
			return accTypes;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> listAccounts() {
		try {
			Query query = manager.createQuery("SELECT a FROM Account a WHERE a.ativo = true");
			List<Account> accounts = query.getResultList();
			return accounts;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage()); 
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean verifyAccountName(Account acc){
		Query query = manager.createQuery("SELECT a FROM Account a WHERE a.descricao =" + acc.getDescricao());
		Object result = query.getResultList();
		
		if(result!= null){
			return true;
		}
		return false;
	}

}
