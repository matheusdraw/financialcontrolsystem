package financialcontrolsystem.controller;

import financialcontrolsystem.model.ConnectionDatabase;

public class Runner {

	public static void main(String[] args) {
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		connectionDatabase.createConnection();
		
		FrameMainControl FrameMainControl = new FrameMainControl();
		FrameMainControl.initializeFrameMain();
	}
}
