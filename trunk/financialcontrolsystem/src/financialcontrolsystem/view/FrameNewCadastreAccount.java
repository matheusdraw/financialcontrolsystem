package financialcontrolsystem.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import financialcontrolsystem.model.AccountTO;
import financialcontrolsystem.view.action.FrameNewCadastreAccountActions;

public class FrameNewCadastreAccount extends JDialog {

	private static final long serialVersionUID = 1L;
	private FrameNewCadastreAccountActions frameNewCadastreAccountActions;
	
	private Container panelMain;
	private JPanel panelForm;								// PAINEL COM OS DADOS DO FORMULÁRIO
	private JPanel panelInfo;								// PAINEL DE INFORMAÇÕES
	private JPanel panelButtons;							// PAINEL COM BOTÕES
	private JLabel labelInfo;								// INFORMAÇÃO SOBRE OS CAMPOS OBRIGATÓRIOS
	private JLabel labelNameAccont; 						// NOME DA CONTA
	private JTextField fieldNameAccount;					// CAMPO PARA INFORMAR O NOME DA CONTA
	private JLabel labelIconNameAccountInfo;
	private JLabel labelInitialValue; 						// VALOR INICIAL DA CONTA
	private JTextField fieldInitialValue;					// CAMPO PARA INFORMAR O VALOR INICIAL DA CONTA
	private JLabel labelIconInitialValueInfo;
	private JLabel labelDateInitialValue; 					// DATA DO VALOR INICIAL DA CONTA
	private JFormattedTextField fieldDateInitialValue;		// CAMPO PARA INFORMAR A DATA EM QUE FOI INFORMADO O SALDO INICIAL
	private JLabel labelIconDateInitialValue;
	private JTextArea areaInfo;								// ARÉA PARA DESCREVER INFORMAÇÕES
	private JButton buttonSalvar;							// BOTÃO PARA SALVAR CADASTRO
	private JButton buttonCancel;							// BOTÃO PARA CANCELAR O NOVO OU EDIÇÃO DO CADASTRO
	
	private AccountTO accountTO;
	
	public FrameNewCadastreAccount(FrameNewCadastreAccountActions frameNewCadastreAccountActions) {
		this.frameNewCadastreAccountActions = frameNewCadastreAccountActions;
		init();
	}

	private void init() {
		setTitle("Cadastro de contas");
		setSize(750, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				getOptionExit();
			}
		});
		
		panelMain = getContentPane();		
		
		
		Color vermelhoEscuro = new Color(193, 205, 205);
		panelMain.setBackground(vermelhoEscuro);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		Constraints constraints = new Constraints();

		panelMain.setLayout(gridBagLayout);
		
		constraints.setInsets(new Insets(5, 5, 5, 5));

		constraints.setAnchor(GridBagConstraints.NORTHWEST);
		constraints.setGridyGridx(0, 0);
		constraints.setGridwidthGridheight(1, 1);
		constraints.setWeightyWeightx(1, 1);
		panelMain.add(getPanelInfo(), constraints);
		
		constraints.setAnchor(GridBagConstraints.NORTHEAST);
		constraints.setGridyGridx(0, 1);
		constraints.setGridwidthGridheight(1, 1);
		constraints.setWeightyWeightx(1, 1);
		panelMain.add(getPanelForm(), constraints);		
		
		constraints.setAnchor(GridBagConstraints.SOUTHEAST);
		constraints.setGridyGridx(1, 1);
		constraints.setGridwidthGridheight(1, 1);
		constraints.setWeightyWeightx(1, 1);
		panelMain.add(getPanelButtons(), constraints);
	
	}

	private JPanel getPanelForm() {
		if (panelForm == null) {
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			Constraints constraints = new Constraints();

			panelForm = new JPanel();
			panelForm.setLayout(gridBagLayout);
			panelForm.setBackground(Color.WHITE);
			
			constraints.setInsets(new Insets(5, 5, 5, 5));

			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(0, 0);
			constraints.setGridwidthGridheight(2, 1);
			constraints.setWeightyWeightx(0, 0);
			panelForm.add(getLabelInfo(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(1, 0);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			panelForm.add(getLabelNomeAccont(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(1, 1);
			constraints.setGridwidthGridheight(3, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(300, 0);
			panelForm.add(getTextNomeAccount(), constraints);	
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(1, 4);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(0, 0);
			panelForm.add(getLabelIconNameAccountInfo(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(2, 0);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(0, 0);
			panelForm.add(getLabelInitialValue(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(2, 1);
			constraints.setGridwidthGridheight(2, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(120, 0);
			panelForm.add(getTextInitialValue(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(2, 3);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(0, 0);
			panelForm.add(getLabelIconInitialValueInfo(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(3, 0);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(0, 0);
			panelForm.add(getLabelDateInitialValue(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(3, 1);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(15, 0);
			panelForm.add(getTextDateInitialValue(), constraints);
			
			constraints.setAnchor(GridBagConstraints.WEST);
			constraints.setGridyGridx(3, 2);
			constraints.setGridwidthGridheight(1, 1);
			constraints.setWeightyWeightx(0, 0);
			constraints.setIpadxIpadY(0, 0);
			panelForm.add(getLabelIconDateInitialValue(), constraints);
			
			
		}
		return panelForm;
	}
	
	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			panelInfo = new JPanel();
			panelInfo.add(getTextInfo());
			panelInfo.setBackground(Color.WHITE);
		}
		return panelInfo;
	}
	
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.add(getButtonSave());
			panelButtons.add(getButtonCancel());
			panelButtons.setBackground(Color.WHITE);
		}
		return panelButtons;
	}
	
	private JLabel getLabelInfo () {
		if (labelInfo == null) {
			labelInfo = new JLabel("Campos com * são obrigatórios.");
			//labelInfo.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		}
		return labelInfo;
	}
	
	private JLabel getLabelNomeAccont() {
		if (labelNameAccont == null) {
			labelNameAccont = new JLabel("Nome da conta *");
			//labelNameAccont.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		}
		return labelNameAccont;
	}
	
	private JTextField getTextNomeAccount() {
		if (fieldNameAccount == null) {
			fieldNameAccount = new JTextField();
			fieldNameAccount.setDocument(new FormatTextField(50));
			//fieldNameAccount.setPreferredSize(new Dimension(20, 20));
		}
		return fieldNameAccount;
	}
	
	private JLabel getLabelIconNameAccountInfo() {
		if (labelIconNameAccountInfo == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("/financialcontrolsystem/icons/icon-info.png"));
			icon.setImage(icon.getImage());
			labelIconNameAccountInfo = new JLabel(icon);
			labelIconNameAccountInfo.setToolTipText("<html> Informe a descrição da conta </html>");
		}
		
		return labelIconNameAccountInfo;
	}

	private JLabel getLabelInitialValue() {
		if (labelInitialValue == null) {
			labelInitialValue = new JLabel("Valor inicial *");
			//labelInitialValue.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		}
		return labelInitialValue;
	}

	private JTextField getTextInitialValue() {
		if (fieldInitialValue == null) {
			fieldInitialValue = new JTextField();
			fieldInitialValue.setDocument(new FormatNumericField(15, 2));
		}
		return fieldInitialValue;
	}
	
	private JLabel getLabelIconInitialValueInfo() {
		if (labelIconInitialValueInfo == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("/financialcontrolsystem/icons/icon-info.png"));
			icon.setImage(icon.getImage());
			labelIconInitialValueInfo = new JLabel(icon);
			labelIconInitialValueInfo.setToolTipText("<html> Informe o valor para o lançamento inicial da conta"
													+ "<br> Exemplo: 100,00 ou 0,10 </html>");
		}
		return labelIconInitialValueInfo;
	}
	
	private JLabel getLabelDateInitialValue() {
		if (labelDateInitialValue == null) {
			labelDateInitialValue = new JLabel("Data de lançamento");
			//labelDateInitialValue.setFont(new Font("", Font.ITALIC, 12));
		}
		return labelDateInitialValue;
	}
	
	private JFormattedTextField getTextDateInitialValue() {
		if (fieldDateInitialValue == null) {
			FormatMaskField formatMaskField = new FormatMaskField();
			fieldDateInitialValue = new JFormattedTextField(formatMaskField.getMaskDateField());
			
		}
		return fieldDateInitialValue;
	}
	
	private JLabel getLabelIconDateInitialValue() {
		if (labelIconDateInitialValue == null) {
			ImageIcon icon = new ImageIcon(getClass().getResource("/financialcontrolsystem/icons/icon-info.png"));
			icon.setImage(icon.getImage());
			labelIconDateInitialValue = new JLabel(icon);
			labelIconDateInitialValue.setToolTipText("<html> Informe a data para o lançamento inicial da conta </html>");
			
		}
		return labelIconDateInitialValue;
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
					+ "\nBradesco, Caixa, Itaú, Carteira, "
					+ "\nCofre.";
			areaInfo.setText(teste);
			areaInfo.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, false), "Informações"));
			areaInfo.setEnabled(false);
			//areaInfo.setFont(new Font("", Font.PLAIN, 12));
		}
		return areaInfo;
	}
	
	private JButton getButtonSave() {
		if (buttonSalvar == null) {
			buttonSalvar = new JButton("Salvar");
			
			buttonSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {					
					actionButtonSave();
					
				}
			});
		}
		return buttonSalvar;
	}
	
	private JButton getButtonCancel() {
		if (buttonCancel == null) {
			buttonCancel = new JButton("Cancelar");
			
			buttonCancel.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					getOptionExit();
				}
			});
		}
		return buttonCancel;
	}
	
	private void getOptionExit() {
		int result = JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Cadastro de contas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			dispose();
		} else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		}
	}
	
	public void actionButtonSave() {
		accountTO = new AccountTO();
		accountTO.setName(fieldNameAccount.getText());
		//accountTO.setInitialValue(Float.parseFloat(fieldInitialValue.getText()));
		//accountTO.setDateInitialValue(fieldDateInitialValue.getText());		
		frameNewCadastreAccountActions.buttonSave(accountTO);
	}
	
}
