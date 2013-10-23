package financialcontrolsystem.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FormatTextField extends PlainDocument {

	private int size;
	
	public FormatTextField(int size) {
		this.size = size;
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		
		StringBuffer content = new StringBuffer(getText(0, getLength()) + str);
		
		if (content.length() > size) {
			return;
		}
		
		super.insertString(offs, str, a);
	}
	
}
