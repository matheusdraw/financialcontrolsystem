package financialcontrolsystem.controller;

import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.model.AccountTO;
import financialcontrolsystem.view.FrameNewCadastreAccount;
import financialcontrolsystem.view.action.FrameNewCadastreAccountActions;

public class FrameNewCadastreAccountControl implements FrameNewCadastreAccountActions {
	
	private AccountDAO accountDAO;
	private FrameNewCadastreAccount frameNewCadastreAccount;
	
	
	public void initializeFrameNewCadastreAccount (){
		accountDAO = new AccountDAO();
		frameNewCadastreAccount = new FrameNewCadastreAccount(this);
		frameNewCadastreAccount.setVisible(true);		
	}

	@Override
	public void buttonSave(AccountTO accountTO) {
		accountDAO.insertNewAccount(accountTO);
	}
	
}
