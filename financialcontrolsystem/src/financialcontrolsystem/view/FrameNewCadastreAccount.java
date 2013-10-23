/**
Copyright (c) 2011-2013 Bernhard Pauler, Tim Molderez
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the Balloon tip Developer Team nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE BALLOON TIP DEVELOPER TEAM BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package financialcontrolsystem.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.Buffer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;

import com.jidesoft.tooltip.BalloonTip;

import financialcontrolsystem.model.LoginTO;
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
	private JLabel labelInitialValue; 						// VALOR INICIAL DA CONTA
	private JTextField fieldInitialValue;					// CAMPO PARA INFORMAR O VALOR INICIAL DA CONTA
	private JLabel labelDateInitialValue; 					// DATA DO VALOR INICIAL DA CONTA
	private JFormattedTextField fieldDateInitialValue;		// CAMPO PARA INFORMAR O VALOR DA DATA EM QUE FOI INFORMADO O SALDO INICIAL
	private JTextArea areaInfo;								// ARÉA PARA DESCREVER INFORMAÇÕES
	private JButton buttonSalvar;							// BOTÃO PARA SALVAR CADASTRO
	private JButton buttonCancel;							// BOTÃO PARA CANCELAR O NOVO OU EDIÇÃO DO CADASTRO
	
	private LoginTO accountTO;
	
	public FrameNewCadastreAccount(FrameNewCadastreAccountActions frameNewCadastreAccountActions) {
		this.frameNewCadastreAccountActions = frameNewCadastreAccountActions;
		init();
	}

	private void init() {
		setTitle("Cadastro de contas");
		setSize(670, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);	
		
		
		
		addWindowListener( new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {				
				getOptionExit();
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
		panelMain.add(getPanelInfo(), constraints);
		
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
		/*ANCHOR*/ GridBagConstraints.SOUTHEAST,
		/*FILL*/ GridBagConstraints.NONE, 
		/*GRIDX*/ 1,
		/*GRIDY*/ 1,
		/*GRIDWIDTH*/ 1,
		/*GRIDHEIGTH*/ 1,
		/*WEIGHTX*/ 0,
		/*WEIGHTY*/ 0,
		/*IPADX*/ 0,
		/*IPADY*/ 0);
		panelMain.add(getPanelButtons(), constraints);
	
	}

	private JPanel getPanelForm() {
		if (panelForm == null) {
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			Constraints constraints = new Constraints();

			panelForm = new JPanel();
			panelForm.setLayout(gridBagLayout);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.WEST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDY*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 2,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 0,
			/*IPADY*/ 0);
			panelForm.add(getLabelInfo(), constraints);
			
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
			panelForm.add(getLabelNomeAccont(), constraints);
			
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
			/*IPADX*/ 305,
			/*IPADY*/ 0);
			panelForm.add(getTextNomeAccount(), constraints);			
			
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
			panelForm.add(getLabelInitialValue(), constraints);
			
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
			/*IPADX*/ 120,
			/*IPADY*/ 0);
			panelForm.add(getTextInitialValue(), constraints);
			
			constraints.setConstraints(
			/*INSETS*/ new Insets(5, 5, 5, 5), 
			/*ANCHOR*/ GridBagConstraints.EAST,
			/*FILL*/ GridBagConstraints.NONE, 
			/*GRIDY*/ 3,
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
			/*GRIDY*/ 3,
			/*GRIDX*/ GridBagConstraints.RELATIVE,
			/*GRIDWIDTH*/ 1,
			/*GRIDHEIGTH*/ 1,
			/*WEIGHTX*/ 0,
			/*WEIGHTY*/ 0,
			/*IPADX*/ 10,
			/*IPADY*/ 0);
			panelForm.add(getTextDateInitialValue(), constraints);
			
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
	
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.add(getButtonSave());
			panelButtons.add(getButtonCancel());
		}
		return panelButtons;
	}
	
	private JLabel getLabelInfo () {
		if (labelInfo == null) {
			labelInfo = new JLabel("Campos com * (destacados em negrito) são obrigatórios.");
			//labelInfo.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		}
		return labelInfo;
	}
	
	private JLabel getLabelNomeAccont() {
		if (labelNameAccont == null) {
			labelNameAccont = new JLabel("Nome da conta*");
			//labelNameAccont.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		}
		return labelNameAccont;
	}
	
	private JTextField getTextNomeAccount() {
		if (fieldNameAccount == null) {
			fieldNameAccount = new JTextField();
			fieldNameAccount.setDocument(new FormatTextField(50));
		}
		return fieldNameAccount;
	}

	private JLabel getLabelInitialValue() {
		if (labelInitialValue == null) {
			labelInitialValue = new JLabel("Valor inicial*");
			labelInitialValue.setToolTipText("<html>Informe o valor inicial da conta."
											+ "<br> Exemplo: 100,00 ou 0,10 </html>");
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
	
	private JLabel getLabelDateInitialValue() {
		if (labelDateInitialValue == null) {
			labelDateInitialValue = new JLabel("Data de lançamento");
			//labelDateInitialValue.setFont(new Font("", Font.ITALIC, 12));
			labelDateInitialValue.setToolTipText("<html>Informe a data do lançamento.");
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
		accountTO = new LoginTO();
		accountTO.setNameAccount(fieldNameAccount.getText());
		accountTO.setInitialValue(Float.parseFloat(fieldInitialValue.getText()));
		accountTO.setDateInitialValue(fieldDateInitialValue.getText());		
		frameNewCadastreAccountActions.buttonSave(accountTO);
	}
	
}
