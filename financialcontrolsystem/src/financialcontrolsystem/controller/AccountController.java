package financialcontrolsystem.controller;

import java.util.List;

import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.model.AccountTO;

public class AccountController {
	
	private AccountDAO accDAO;
	
	public void createAccount(AccountTO accountTO){
		accDAO = new AccountDAO();
		accDAO.createNewAccount(accountTO);
	}
	
	public List<AccountTO> listAccounts(){
		accDAO = new AccountDAO();
		List<AccountTO> accounts;
		
		accounts = accDAO.listAllAccounts();
		
		return accounts;
	}
}
