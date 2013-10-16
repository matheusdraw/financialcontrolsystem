package financialcontrolsystem.view;

import javax.swing.JDialog;

public class CadastreAccount extends JDialog {

	private static final long serialVersionUID = 1L;

	private String nomeAccont;
	
	public CadastreAccount() {
		init();
	}
	
	private void init() {
		setTitle("Cadastro de contas");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setModal(true);
	}
	
}
