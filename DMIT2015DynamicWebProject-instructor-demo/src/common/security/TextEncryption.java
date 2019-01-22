package common.security;

import javax.swing.JOptionPane;

import org.jasypt.util.text.StrongTextEncryptor;

public class TextEncryption {

	public static void main(String[] args) {
		// Prompt and read in the password for encyption/description using Jasypt
		String masterPassword = JOptionPane.showInputDialog("Enter password for encryption:");
		
		// Prompt and read in the a plain text value to encrypt
		String plainText = JOptionPane.showInputDialog("Enter the text to encrypt: ");
		
		// Encrypted the plain text value into cipher text
		StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
		textEncryptor.setPassword(masterPassword);
		String cipherText = textEncryptor.encrypt(plainText);
		
		// Display the cipher text value on the Console and also using JOptionPane
		String message = String.format("The encrypted value for %s is %s", plainText, cipherText);
		System.out.println(message);
		JOptionPane.showMessageDialog(null, message);
		
		// Write the Java code to copy the cipherText to the system clipboard

	}

}
