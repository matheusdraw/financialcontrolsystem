package financialcontrolsystem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import financialcontrolsystem.view.action.FrameMainActions;

public class MenuAccount {

	private JMenu menuAccount;
	private JMenuItem itemNewAccount;
	private FrameMainActions frameMainActions;

	public MenuAccount(FrameMainActions frameMainActions) {
		this.frameMainActions = frameMainActions;
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
					frameMainActions.itemNewAccount();
				}
			});
		}
		return itemNewAccount;
	}
	
	public JMenu getMenuAccount() {
		return menuAccount;
	}

}
