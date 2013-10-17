package financialcontrolsystem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuAccount {

	private JMenu menuAccount;
	private JMenuItem itemNewAccount;

	public MenuAccount() {
		init();
	}
	
	private void init() {
		if (menuAccount == null) {
			menuAccount = new JMenu("Contas");
			menuAccount.add(getItemNewAccount());
		}
	}

	private JMenuItem getItemNewAccount() {
		if (itemNewAccount == null) {
			itemNewAccount = new JMenuItem("Nova conta");
			itemNewAccount.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					FrameNewCadastreAccount c = new FrameNewCadastreAccount();
					c.setVisible(true);
				}
			});
		}
		return itemNewAccount;
	}
	
	public JMenu getMenuAccount() {
		return menuAccount;
	}

}
