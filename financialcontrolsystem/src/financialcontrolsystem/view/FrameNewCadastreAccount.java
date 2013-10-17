package financialcontrolsystem.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FrameNewCadastreAccount extends JDialog {

	private static final long serialVersionUID = 1L;

	private Container panelMain;
	private JPanel panelForm;

	private JLabel labelNomeAccont; 				// NOME DA CONTA
	private JTextField textNomeAccount;				// CAMPO PARA INFORMAR O NOME DA CONTA
	private JLabel labelInitialValue; 				// VALOR INICIAL DA CONTA
	private JTextField textInitialValue;			// CAMPO PARA INFORMAR O VALOR INICIAL DA CONTA
	private JLabel labelDateInitialValue; 			// DATA DO VALOR INICIAL DA CONTA
	private JTextField textDateInitialValue;		// CAMPO PARA INFORMAR O VALOR DA DATA EM QUE FOI INFORMADO O SALDO INICIAL
	
	public FrameNewCadastreAccount() {
		init();
	}

	private void init() {
		setTitle("Cadastro de contas");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setModal(true);

		panelMain = getContentPane();		

		GridBagConstraints teste = new GridBagConstraints();		
		GridBagLayout gridBagLayout = new GridBagLayout();
		panelMain.setLayout(gridBagLayout);
		 
		teste.insets = new Insets(2,2,2,2);
		teste.weightx = 1;  
		teste.weighty = 1;  
		teste.anchor = GridBagConstraints.NORTHWEST;
		
		panelMain.add(getPanelMain(), teste);
	}

	private JPanel getPanelMain() {
		
		if (panelForm == null) {
			panelForm = new JPanel();
			GridBagLayout gridBagLayout = new GridBagLayout();
			panelForm.setLayout(gridBagLayout);
			panelForm.add(getLabelNomeAccont(), getConstraints(0, 0, 0, 300));
			panelForm.add(getTextNomeAccount(), getConstraints(1, 0, 0, 0));
			panelForm.add(getLabelInitialValue(), getConstraints(0, 1, 1, 1));
			panelForm.add(getLabelDateInitialValue(), getConstraints(0, 2, 1, 1));
			panelForm.setBorder(new LineBorder(Color.GRAY, 1, false));
		}
		return panelForm;
	}

	private GridBagConstraints getConstraints(int coluna, int linha, int largura, int ipadx) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.insets = new Insets(5,5,5,5);
		constraints.gridwidth = largura;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipadx = ipadx;
		return constraints;
	}
	
	private JLabel getLabelNomeAccont() {
		if (labelNomeAccont == null) {
			labelNomeAccont = new JLabel("Nome da conta:");
		}
		return labelNomeAccont;
	}
	
	private JTextField getTextNomeAccount() {
		if (textNomeAccount == null) {
			textNomeAccount = new JTextField();
		}
		return textNomeAccount;
	}

	private JLabel getLabelInitialValue() {
		if (labelInitialValue == null) {
			labelInitialValue = new JLabel("Valor inicial:");
		}

		return labelInitialValue;
	}

	public JLabel getLabelDateInitialValue() {
		if (labelDateInitialValue == null) {
			labelDateInitialValue = new JLabel("Data de lançamento:");
		}
		return labelDateInitialValue;
	}
}
