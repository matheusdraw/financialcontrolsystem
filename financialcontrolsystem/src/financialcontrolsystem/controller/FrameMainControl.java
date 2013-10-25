package financialcontrolsystem.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.Silver;
import financialcontrolsystem.view.FrameMain;
import financialcontrolsystem.view.action.FrameMainActions;

/**********************************************************************************
 * CLASSE QUE CONTROLA A JANELA PRINCIPAL
 *********************************************************************************/
public class FrameMainControl implements FrameMainActions {
	
	private FrameMain frameMain;
	private FrameCadastreNewAccControl frameNewCadastreAccountControl;

	public void initializeFrameMain() {
		
		/*try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());

					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}*/

		/******************************************************************************
		 * TEMAS DO JGOODIES:
		 * 
		 * Sky Yellow, Sky Red, Sky Pink, Sky Krupp, Sky Green, Sky Bluer, Sky
		 * Blue, Silver, Light Gray, Experience Royale, Experience Green,
		 * Experience Blue, Desert Yellow, Desert Red, Desert Green, Desert
		 * Bluer, Desert Blue, Dark Star e Brown Sugar
		 ******************************************************************************/
		PlasticXPLookAndFeel.setPlasticTheme(new Silver());
		try {
			UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frameMain = new FrameMain(this);
		frameMain.setVisible(true);
	}
		
	@Override
	public void itemExitAction() {
		System.exit(0);
	}

	@Override
	public void itemNewAccount() {
		frameNewCadastreAccountControl = new FrameCadastreNewAccControl();
		frameNewCadastreAccountControl.initializeFrameNewCadastreAccount();
	}
}
