package financialcontrolsystem.controller;

import financialcontrolsystem.model.AccountDAO;
import financialcontrolsystem.view.FrameNewCadastreAccount;
import financialcontrolsystem.view.action.FrameNewCadastreAccountActions;

public class FrameCadastreNewAccControl implements FrameNewCadastreAccountActions {
	
	private AccountDAO accountDAO;
	private FrameNewCadastreAccount frameNewCadastreAccount;
	
	public String[] getAccTypes(){
		String accTypes [] = {"Carteira","Conta Corrente","Poupança"};
		return accTypes;
	}
	
	public void initializeFrameNewCadastreAccount (){
		accountDAO = new AccountDAO();
		frameNewCadastreAccount = new FrameNewCadastreAccount(this);
		frameNewCadastreAccount.setVisible(true);		
	}

	@Override
	public void buttonSave(AccountDAO accountTO) {
		accountDAO.insertNewLogin(accountTO);
	}
	
}
