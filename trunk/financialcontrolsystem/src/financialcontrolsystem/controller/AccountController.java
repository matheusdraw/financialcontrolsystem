package financialcontrolsystem.controller;

import java.util.List;

import financialcontrolsystem.model.Account;
import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.model.AccountType;
import financialcontrolsystem.model.bi.AccountBI;

public class AccountController {
	
	private AccountDAO accDAO = new AccountDAO();
	private AccountBI accBI = new AccountBI();
	
	public boolean createAccount(Account account){
		return accDAO.create(account);
	}

	public List<AccountType> getAccTypes() {
		return accBI.listTypes();
	}

	public List<Account> listAccounts() {
		return accBI.listAccounts();
	}

	public boolean delAccount(Account account) {
		account.setAtivo(false);
		return accDAO.delete(account);
		
	}
}
