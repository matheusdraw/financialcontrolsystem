package financialcontrolsystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

public class PanelTabOverview extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel panelMain;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JSplitPane splitPane1;
	private JSplitPane splitPane2;
	
	public PanelTabOverview() {
		init();
	}
	
	private void init() {
		if (panelMain == null) {
			panelMain = new JPanel();
			panelMain.setBorder(new LineBorder(Color.GRAY));
			
			BorderLayout layout = new BorderLayout();
			panelMain.setLayout(layout);
			panelMain.add(getSplitPane1(), BorderLayout.CENTER);
		}
	}
	
	public JPanel getPanelTabOverview() {
		return panelMain;
	}
	
	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBorder(new LineBorder(Color.GRAY));
		}
		return panel1;
	}
	
	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setBorder(new LineBorder(Color.GRAY));
		}
		return panel2;
	}
	
	private JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.setBorder(new LineBorder(Color.GRAY));
			
		}
		return panel3;
	}
	
	
	private  JSplitPane getSplitPane1() {
		if (splitPane1 == null) {
			splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			splitPane1.setDividerSize(2);
			splitPane1.setDividerLocation(230);
			splitPane1.setResizeWeight(0.0);

			splitPane1.setLeftComponent(getPanel2());
			splitPane1.setRightComponent(getSplitPane2());
		}
		return splitPane1;
	}
	
	private JSplitPane getSplitPane2() {
		if (splitPane2 == null) {
			splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			splitPane2.setDividerSize(2);
			splitPane2.setDividerLocation(520);
			splitPane2.setResizeWeight(0.0);

			splitPane2.setLeftComponent(getPanel3());
			splitPane2.setRightComponent(getPanel1());
		}
		return splitPane2;
	}
	
}
