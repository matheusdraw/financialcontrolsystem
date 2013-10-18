package financialcontrolsystem.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Constraints extends GridBagConstraints {

	private static final long serialVersionUID = 1L;

	public void setConstraints(Insets insets, int anchor, int fill, int gridy,
			int gridx, int gridwidth, int gridheight, double weightx,
			double weighty, int ipadx, int ipady) {

		this.insets = insets;									// INSETS = new Insets(0, 0, 0, 0)
		this.anchor = anchor;									// ANCHOR = GridBagConstraints.CENTER
		this.fill = fill;										// FILL = GridBagConstraints.NONE
		this.gridy = gridy;										// GRIDY = GridBagConstraints.RELATIVE
		this.gridx = gridx;										// GRIDX = GridBagConstraints.RELATIVE
		this.gridwidth = gridwidth;								// GRIDWIDTH = 1
		this.gridheight = gridheight;							// GRIDHEIGTH = 1
		this.weightx = weightx;  								// WEIGHTX = 0
		this.weighty = weighty;									// WEIGHTY = 0
		this.ipadx = ipadx;										// IPADX = 0
		this.ipady = ipady;										// IPADY = 0
		
//		constraints.setConstraints(
//		/*INSETS*/ new Insets(0, 0, 0, 0), 
//		/*ANCHOR*/ GridBagConstraints.CENTER,
//		/*FILL*/ GridBagConstraints.NONE, 
//		/*GRIDX*/ GridBagConstraints.RELATIVE,
//		/*GRIDY*/ GridBagConstraints.RELATIVE,
//		/*GRIDWIDTH*/ 1,
//		/*GRIDHEIGTH*/ 1,
//		/*WEIGHTX*/ 0,
//		/*WEIGHTY*/ 0,
//		/*IPADX*/ 0,
//		/*IPADY*/ 0);
	}
}
