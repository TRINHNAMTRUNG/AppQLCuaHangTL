package custom_Gui;


import java.awt.*;
import java.awt.font.TextAttribute;
import java.math.*;
import java.text.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.JFormattedTextField.*;
import javax.swing.event.*;
import javax.swing.text.InternationalFormatter;

public class Ad {

	public Ad() {
		JFrame frame = new JFrame("AbstractTextField Test");
		final JFormattedTextField textField1 = new JFormattedTextField(new Double(10.01));
		textField1.setFormatterFactory(new AbstractFormatterFactory() {
			@Override
			public AbstractFormatter getFormatter(JFormattedTextField tf) {
				NumberFormat format = DecimalFormat.getCurrencyInstance();
				format.setMinimumFractionDigits(2);
				format.setMaximumFractionDigits(2);
				format.setRoundingMode(RoundingMode.HALF_UP);
				InternationalFormatter formatter = new InternationalFormatter(format);
				formatter.setAllowsInvalid(false);
				//formatter.setMinimum(0.0);
				//formatter.setMaximum(1000.00);
				return formatter;
			}
		});
		final Map attributes = (new Font("Serif", Font.BOLD, 16)).getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		final JFormattedTextField textField2 = new JFormattedTextField(new Double(10.01));
		textField2.setFormatterFactory(new AbstractFormatterFactory() {
			@Override
			public AbstractFormatter getFormatter(JFormattedTextField tf) {
				NumberFormat format = DecimalFormat.getInstance();
				format.setMinimumFractionDigits(3);
				format.setMaximumFractionDigits(3);
				format.setRoundingMode(RoundingMode.HALF_UP);
				InternationalFormatter formatter = new InternationalFormatter(format);
				formatter.setAllowsInvalid(false);
				//formatter.setMinimum(0.0);
				//formatter.setMaximum(1000.00);
				return formatter;
			}
		});
		textField2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent documentEvent) {
				printIt(documentEvent);
			}

			@Override
			public void insertUpdate(DocumentEvent documentEvent) {
				printIt(documentEvent);
			}

			@Override
			public void removeUpdate(DocumentEvent documentEvent) {
				printIt(documentEvent);
			}

			private void printIt(DocumentEvent documentEvent) {
				DocumentEvent.EventType type = documentEvent.getType();
				double t1a1 = (((Number) textField2.getValue()).doubleValue());
				if (t1a1 > 1000) {
					Runnable doRun = new Runnable() {
						@Override
						public void run() {
							textField2.setFont(new Font(attributes));
							textField2.setForeground(Color.red);
						}
					};
					SwingUtilities.invokeLater(doRun);
				} else {
					Runnable doRun = new Runnable() {
						@Override
						public void run() {
							textField2.setFont(new Font("Serif", Font.BOLD, 16));
							textField2.setForeground(Color.black);
						}
					};
					SwingUtilities.invokeLater(doRun);
				}
			}
		});
		//https://stackoverflow.com/a/20008786/714968


		JFormattedTextField jftf2 = new JFormattedTextField();
		final InternationalFormatter fmt = new InternationalFormatter(
				new MessageFormat("{0,number,000}-{1,number,0000}"));
		jftf2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
			public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
				return fmt;
			}
		});


		frame.setSize(400,200);
		jftf2.setValue(new Object[]{111, 1234});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textField1, BorderLayout.NORTH);
		frame.add(textField2, BorderLayout.CENTER);
		frame.add(jftf2, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Ad main = new Ad();
			}
		});
	}
}