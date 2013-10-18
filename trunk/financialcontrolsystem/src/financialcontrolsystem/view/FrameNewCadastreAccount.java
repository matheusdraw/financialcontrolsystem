package financialcontrolsystem.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FrameNewCadastreAccount extends JDialog {

	private static final long serialVersionUID = 1L;

	private Container panelMain;
	private JPanel panelForm;
	private JPanel panelInfo;

	private JLabel labelNomeAccont; 				// NOME DA CONTA
	private JTextField fieldNomeAccount;			// CAMPO PARA INFORMAR O NOME DA CONTA
	private JLabel labelInitialValue; 				// VALOR INICIAL DA CONTA
	private JTextField fielddInitialValue;			// CAMPO PARA INFORMAR O VALOR INICIAL DA CONTA
	private JLabel labelDateInitialValue; 			// DATA DO VALOR INICIAL DA CONTA
	private JTextField fieldDateInitialValue;		// CAMPO PARA INFORMAR O VALOR DA DATA EM QUE FOI INFORMADO O SALDO INICIAL
	private JTextArea areaInfo;						// ARÉA PARA DESCREVER INFORMAÇÕES
	
	public FrameNewCadastreAccount() {
		init();
	}

	private void init() {
		setTitle("Cadastro de contas");
		setSize(550, 280);
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);	
		
		addWindowListener( new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {				
				int result = JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Cadastro de contas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				} else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}			
		});

		panelMain = getContentPane();		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		Constraints constraints = new Constraints();

		panelMain.setLayout(gridBagLayout);
		
		constraints.setConstraints(
		/*INSETS*/ new Insets(5, 5, 5, 5), 
		/*ANCHOR*/ GridBagConstraints.NORTHWEST,
		/*FILL*/ GridBagConstraints.NONE, 
		/*GRIDX*/ GridBagConstraints.RELATIVE,
		/*GRIDY*/ GridBagConstraints.RELATIVE,
		/*GRIDWIDTH*/ 1,
		/*GRIDHEIGTH*/ 1,
		/*WEIGHTX*/ 1,
		/*WEIGHTY*/ 1,
		/*IPADX*/ 0,
		/*IPADY*/ 0);		
		panelMain.add(getPanelForm(), constraints);
		
		constraints.setConstraints(
		/*INSETS*/ new Insets(5, 5, 5, 5), 
		/*ANCHOR*/ GridBagConstraints.NORTHEAST,
		/*FILL*/ GridBagConstraints.NONE, 
		/*GRIDX*/ GridBagConstraints.RELATIVE,
		/*GRIDY*/ GridBagConstraints.RELATIVE,
		/*GRIDWIDTH*/ 1,
		/*GRIDHEIGTH*/ 1,
		/*WEIGHTX*/ 1,
		/*WEIGHTY*/ 1,
		/*IPADX*/ 0,
		/*IPADY*/ 0);
		panelMain.add(getPanelInfo(), constraints);
	}

	private JPanel getPanelForm() {
		if (panelForm == null) {
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			Constraints constraints = new Constraints();

			panelForm = new JPanel();
			panelForm.setLayout(gridBagLayout);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.EAST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ GridBagConstraints.RELATIVE,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 0,
			/*IPADY*/ 0);
			panelForm.add(getLabelNomeAccont(), constraints);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.WEST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ GridBagConstraints.RELATIVE,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 200,
			/*IPADY*/ 0);
			panelForm.add(getTextNomeAccount(), constraints);			
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.EAST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ 1,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 0,
			/*IPADY*/ 0);
			panelForm.add(getLabelInitialValue(), constraints);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.WEST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ 1,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 80,
			/*IPADY*/ 0);
			panelForm.add(getTextInitialValue(), constraints);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.EAST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ 2,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 0,
			/*IPADY*/ 0);
			panelForm.add(getLabelDateInitialValue(), constraints);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.WEST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ 2,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 80,
			/*IPADY*/ 0);
			panelForm.add(getTextDateInitialValue(), constraints);
			//panelForm.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, false), "Nova conta"));
		}
		return panelForm;
	}
	
	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			panelInfo = new JPanel();
			panelInfo.add(getTextInfo());
		}
		return panelInfo;
	}
	
	private JLabel getLabelNomeAccont() {
		if (labelNomeAccont == null) {
			labelNomeAccont = new JLabel("Nome da conta:");
		}
		return labelNomeAccont;
	}
	
	private JTextField getTextNomeAccount() {
		if (fieldNomeAccount == null) {
			fieldNomeAccount = new JTextField();
		}
		return fieldNomeAccount;
	}

	private JLabel getLabelInitialValue() {
		if (labelInitialValue == null) {
			labelInitialValue = new JLabel("Valor inicial:");
		}
		return labelInitialValue;
	}

	private JTextField getTextInitialValue() {
		if (fielddInitialValue == null) {
			fielddInitialValue = new JTextField();
		}
		return fielddInitialValue;
	}
	
	private JLabel getLabelDateInitialValue() {
		if (labelDateInitialValue == null) {
			labelDateInitialValue = new JLabel("Data de lançamento:");
		}
		return labelDateInitialValue;
	}
	
	private JTextField getTextDateInitialValue() {
		if (fieldDateInitialValue == null) {
			fieldDateInitialValue = new JTextField();
		}
		return fieldDateInitialValue;
	}
	
	private JTextArea getTextInfo() {
		if (areaInfo == null) {
			areaInfo = new JTextArea();
			String teste = "O que é uma conta?"
					+ "\nAs contas indicam de onde"
					+ "\no dinheiro entrou ou saiu,"
					+ "\npodendo ser contas bancárias"
					+ "\nou não."
					+ "\n\nExemplos de contas:"
					+ "\nBradesco, Caixa, Itaú, Carteira,"
					+ "\nCofre.";
			areaInfo.setText(teste);
			areaInfo.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, false), "Informações"));
			areaInfo.setEnabled(false);
		}
		return areaInfo;
	}
	
}
