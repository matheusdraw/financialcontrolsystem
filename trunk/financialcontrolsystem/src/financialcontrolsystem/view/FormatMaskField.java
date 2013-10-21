package financialcontrolsystem.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

public class FormatMaskField extends PlainDocument {

	private static final long serialVersionUID = 1L;
	
	
	// "#" = QUALQUER NÚMERO VÁLIDO (0-9)
	// "U" = QUALQUER LETRA (a-z), TODAS AS LETRAS INSERIDAS SERÃO CONVERTIDAS
	// PARA MAIÚSCULAS
	// "L" = QUALQUER LETRA (a-z), TODAS AS LETRAS INSERIDAS SERÃO CONVERTIDAS
	// PARA MINÚSCULAS
	// "A" = QUALQUER LETRA (a-z) OU NÚMERO (a-z)
	// "?" = QUALQUER LETRA (a-z)
	// "H" = QUALQUER CARACTERE HEXADECIMAL (0-9 OU a-f)
	// "*" = TODOS, INCLUINDO CARACTERES ESPECIAIS

	public MaskFormatter getMaskDateField() {

		MaskFormatter maskDateField = new MaskFormatter();

		try {
			maskDateField.setMask("##/##/####");
			maskDateField.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maskDateField;
	}
	
//	public void formatNumericFloat(KeyEvent f, final JTextField x) {
//		
//	
//		
//		class MyKeyListener implements KeyListener {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				JTextField fieldInitialValue = x;
//									
//				if (fieldInitialValue.getText().length() > 10) {
//					e.consume();
//				}
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				JTextField fieldInitialValue = x;
//				//fieldInitialValue.setText(fieldInitialValue.getText().replaceAll("[^0-9 && ,.]", ""));
//				
//				StringBuffer stringBuffer = new StringBuffer(fieldInitialValue.getText());
//				String texto = fieldInitialValue.getText();
//				texto.replaceAll("[^0-9 && ,.]", "");
//				fieldInitialValue.setText(texto);
//				
//				if (stringBuffer.length() == 2) {
//					stringBuffer.insert(1, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 3) {
//					stringBuffer.insert(1, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 4) {
//					stringBuffer.insert(2, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 5) {
//					stringBuffer.insert(3, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 6) {
//					stringBuffer.insert(1, ".");
//					stringBuffer.insert(5, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 7) {
//					stringBuffer.insert(2, ".");
//					stringBuffer.insert(6, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 8) {
//					stringBuffer.insert(3, ".");
//					stringBuffer.insert(7, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 9) {
//					stringBuffer.insert(1, ".");
//					stringBuffer.insert(5, ".");
//					stringBuffer.insert(9, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 10) {
//					stringBuffer.insert(2, ".");
//					stringBuffer.insert(6, ".");
//					stringBuffer.insert(10, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				} else if (stringBuffer.length() == 11) {
//					stringBuffer.insert(3, ".");
//					stringBuffer.insert(7, ".");
//					stringBuffer.insert(11, ",");
//					fieldInitialValue.setText(stringBuffer.toString());
//				}
//				
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			
//		}
//		MyKeyListener m = new MyKeyListener();
//		m.keyPressed(f);
//		m.keyReleased(f);
//		
//	}

}
