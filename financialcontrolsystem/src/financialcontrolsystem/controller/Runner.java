package financialcontrolsystem.controller;

import financialcontrolsystem.model.AccountDAO;

public class Runner {

	public static void main(String[] args) {
		AccountDAO account = new AccountDAO();
		
		FrameMainControl FrameMainControl = new FrameMainControl();
		FrameMainControl.initializeFrameMain();
	}
}
