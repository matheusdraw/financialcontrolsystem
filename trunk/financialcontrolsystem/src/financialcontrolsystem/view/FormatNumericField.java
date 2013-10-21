package financialcontrolsystem.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FormatNumericField extends PlainDocument {

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		
		// getText = TRAZ O QUE TEM NO CAMPO JTextField
		// str = É O QUE FOI DIGITADO MAS NÃO INSERIDO NO CAMPO ATÉ CHAMAR super.insertString(offs, str, a);		
				
		StringBuffer content = new StringBuffer(getText(0, getLength()) + str);
		
		if (content.length() > 5) {
			return;
		}
		
		String contentOk = content.toString();
		contentOk = contentOk.replaceAll("a", "");
		
		System.out.println("O que foi digitado: " + str);		
		System.out.println("O que tem no campo: "+ getText(0, getLength()));
		System.out.println("O que tem no campo + o que foi digitado: " + content);
		System.out.println("Valor final: " + contentOk);
		
		super.insertString(offs, str, a);
	}
	
}
