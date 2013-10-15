package financialcontrolsystem.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PanelTabClients extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JLabel labelCpf;
	private JLabel labelRG;
	private JLabel labelName;
	private JTextField textFieldCpf;
	private JTextField textFieldRG;
	private JTextField textFieldName;

	public PanelTabClients() {
		init();
	}

	private void init() {
		if (panelMain == null) {
			panelMain = new JPanel();
			panelMain.setBorder(new LineBorder(Color.GRAY));

			GridBagLayout layout = new GridBagLayout();
			panelMain.setLayout(layout);

			panelMain.add(getLabelCpf(), getConstraints(0, 0, 1, 1));
			panelMain.add(getTextFieldCpf(), getConstraints(1, 0, 3, 200));
			panelMain.add(getLabelRG(), getConstraints(4, 0, 1, 0));
			panelMain.add(getTextFieldRG(), getConstraints(5, 0, 3, 200));
			panelMain.add(getLabelName(), getConstraints(0, 2, 1, 1));
			panelMain.add(getTextFieldName(), getConstraints(1, 2, 100, 400));
		}
	}

	public JPanel getPanelTabClients() {
		return panelMain;
	}

	private GridBagConstraints getConstraints(int coluna, int linha,
			int largura, int ipadx) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.insets = new Insets(4, 4, 4, 4);
		constraints.gridwidth = largura;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipadx = ipadx;
		return constraints;
	}

	private JLabel getLabelCpf() {
		if (labelCpf == null) {
			labelCpf = new JLabel("CPF:");
		}
		return labelCpf;
	}

	private JTextField getTextFieldCpf() {
		if (textFieldCpf == null) {
			textFieldCpf = new JTextField();
		}
		return textFieldCpf;
	}

	private JLabel getLabelRG() {
		if (labelRG == null) {
			labelRG = new JLabel("R.G.:");
		}
		return labelRG;
	}

	private JTextField getTextFieldRG() {
		if (textFieldRG == null) {
			textFieldRG = new JTextField();
		}
		return textFieldRG;
	}

	private JLabel getLabelName() {
		if (labelName == null) {
			labelName = new JLabel("Nome:");
		}
		return labelName;
	}

	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
		}
		return textFieldName;
	}
}
