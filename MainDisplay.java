import java.awt.event.*;

import javax.swing.*;


public class MainDisplay 
{
	//public static JPanel panel = new JPanel();
	public static void main(String[] args)
	{
		JPanel panel = new JPanel();
		JFrame mainWindow = new JFrame("Ceaser Cipher");
		mainWindow.setSize(800, 450);
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String initialMessage = "This is an example message text. \nEdit this to your own text. \nAnd finally type one letter key and encrypt the message.";
		
		JTextArea inputArea = new JTextArea(initialMessage,10, 70);
		inputArea.setBounds(10, 10, 750, 200);
		
		JTextField keyField = new JTextField(10);
		JTextField keyInstruct = new JTextField("Enter Key here...", 10);
		keyInstruct.setBackground(null);
		keyInstruct.setBorder(null);
		keyInstruct.setBounds(10, 100, 100, 100);
		keyField.setBounds(50, 100, 100, 100);
		
		JButton encryptButton = new JButton("ENCRYPT");
		encryptButton.setBounds(90, 100, 100, 70);
		
		JTextArea outputArea = new JTextArea(10, 70);
		outputArea.setBounds(10, 300, 750, 200);
		
		encryptButton.addActionListener(new ActionListener()
			{
	
			
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					String message = inputArea.getText();
					String key = keyField.getText();
					String encrypted = encrypt(message, key);
					outputArea.setText(encrypted);
				}
				
			
			}
		);
		
		keyField.addKeyListener(new KeyListener()
				{
					
					@Override
					public void keyReleased(KeyEvent event)
					{
						
					}
					@Override
					public void keyTyped(KeyEvent event)
					{
						
					}
					@Override
					public void keyPressed(KeyEvent event)
					{
						keyField.setText("");
					}
				}
				
		);
		
		keyField.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg1)
				{
					
				}
			}
		);
		
		panel.add(inputArea);
		panel.add(keyInstruct);
		panel.add(keyField);
		panel.add(encryptButton);
		panel.add(outputArea);
		mainWindow.add(panel);
		
		mainWindow.setVisible(true);
	}
	
	public static String encrypt(String message, String key)
	{
		key.toLowerCase();
		char[] m = message.toCharArray();
		char[] k = key.toCharArray();
		char[] e = new char[message.length()];
		int l = message.length();
		int keyInt = (int) k[0];
		keyInt -= 97;
		if(keyInt < 0 || keyInt > 25)
		{
			return "The Key pressed isn't accurate";
		}
		String encrypted = "";
		
		for(int i = 0; i<l; i++)
		{
			int enc;
			int msg = (int) m[i];
			if(msg >= 65 && msg <=90 || msg >= 97 && msg <= 122)
				enc = msg + keyInt;
			else
				enc = msg;
			if(msg >= 65 && msg <= 90)
			{
				if(enc > 90)
					enc = (enc % 91) + 65;
			}
			else if(msg >= 97 && msg <= 122)
			{
				if(enc > 122)
					enc = (enc % 123) + 97;
			}
			
			e[i] = (char)enc;
			encrypted += e[i];
		}
		
		return encrypted;
	}
	
}
