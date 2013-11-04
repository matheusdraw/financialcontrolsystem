package financialcontrolsystem.controller;

import java.util.List;

import financialcontrolsystem.model.Account;
import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.model.AccountType;

public class AccountController {
	
	private AccountDAO accDAO;
	
	public void createAccount(Account account){
		accDAO = new AccountDAO();
		accDAO.createNewAccount(account);
	}

	public List<AccountType> getAccTypes() {
		accDAO = new AccountDAO();
		return accDAO.listTypes();
	}
	
	/*public List<Account> listAccounts(){
		accDAO = new AccountDAO();
		List<Account> accounts;
		
		accounts = accDAO.listAllAccounts();
		
		return accounts;
	}*/
}
