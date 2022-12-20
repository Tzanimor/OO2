package oo2.act;

public interface Cipher {
	
	public String cipher(String inputText);

	public String decipher(String inputText);
	
	public default ComplexCipher add(Cipher c2) {
		return new ComplexCipher(this, c2);
	}
}