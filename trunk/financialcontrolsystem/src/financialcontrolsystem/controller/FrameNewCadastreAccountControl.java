package financialcontrolsystem.controller;

import financialcontrolsystem.model.LoginDAO;
import financialcontrolsystem.model.LoginTO;
import financialcontrolsystem.view.FrameNewCadastreAccount;
import financialcontrolsystem.view.action.FrameNewCadastreAccountActions;

public class FrameNewCadastreAccountControl implements FrameNewCadastreAccountActions {
	
	private LoginDAO accountDAO;
	private FrameNewCadastreAccount frameNewCadastreAccount;
	
	
	public void initializeFrameNewCadastreAccount (){
		accountDAO = new LoginDAO();
		frameNewCadastreAccount = new FrameNewCadastreAccount(this);
		frameNewCadastreAccount.setVisible(true);		
	}

	@Override
	public void buttonSave(LoginTO loginTO) {
		accountDAO.insertNewLogin(loginTO);
	}
	
}
