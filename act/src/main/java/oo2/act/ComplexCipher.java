package oo2.act;

public class ComplexCipher implements Cipher {
	
	private Cipher[] ciphers; 
	
	
	public ComplexCipher(Cipher c1, Cipher c2) {
		ciphers = new Cipher[2];
		ciphers[0] = c1;
		ciphers[1] = c2;
	}
	
	public String cipher(String inputText) {
		String st = inputText;
		for (int i = 0; i < ciphers.length; i++)
			st = ciphers[i].cipher(st);
		return st;
	}

	public String decipher(String inputText) {
		String st = inputText;
		for (int i = ciphers.length - 1; i >= 0; i--) {
			st = ciphers[i].decipher(st);
		}
		return st;
	}
}
