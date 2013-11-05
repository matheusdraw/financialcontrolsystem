package financialcontrolsystem.controller;

import java.util.List;

import financialcontrolsystem.model.Account;
import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.model.AccountType;

public class AccountController {
	
	private AccountDAO accDAO = new AccountDAO();
	
	public boolean createAccount(Account account){
		return accDAO.createNewAccount(account);
	}

	public List<AccountType> getAccTypes() {
		return accDAO.listTypes();
	}

	public List<Account> listAccounts() {
		return accDAO.listAccounts();
	}

	public boolean delAccount(Account account) {
		account.setAtivo(false);
		return accDAO.delAccount(account);
		
	}
}
