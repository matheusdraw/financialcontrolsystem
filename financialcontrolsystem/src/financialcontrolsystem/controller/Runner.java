package financialcontrolsystem.controller;

import financialcontrolsystem.model.LoginDAO;

public class Runner {

	public static void main(String[] args) {
		LoginDAO account = new LoginDAO();
		
		FrameMainControl FrameMainControl = new FrameMainControl();
		FrameMainControl.initializeFrameMain();
	}
}
