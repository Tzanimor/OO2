package oo2.act;

public class CesarCipher extends SubsitutionCipher {

	private int jump;

	public CesarCipher(int number, String inputAlphabet) {
		setAlphabet(inputAlphabet);
		setJump(number);
	}

	public CesarCipher(int number) {
		setAlphabet("abcdefghijklmnopqrstuvwxyz");
		setJump(number);
	}

	public String cipher(String inputText) {
		return super.cipher(inputText);
	}

	public String decipher(String inputText) {
		return super.decipher(inputText);
	}

	protected char cipherChar(char inputChar) {
		if (inputChar == ' ') // Espacios se mantienen
			return ' ';
		int offset = searchChar(inputChar) + jump;
		char result = (offset < alphabet.length) ? alphabet[offset] : alphabet[offset - alphabet.length]; // Controla el salto
		return setCase(inputChar, result);
	}

	protected char decipherChar(char inputChar) {
		if (inputChar == ' ') // Espacios se mantienen
			return ' ';
		int offset = searchChar(inputChar) - jump;
		char result = (offset >= 0) ? alphabet[offset] : alphabet[alphabet.length + offset]; // Controla el salto
		return setCase(inputChar, result);
	}

	public void setJump(int newJump) {
		this.jump = (newJump < 0) ? alphabet.length + (newJump % alphabet.length) : newJump % alphabet.length;
	}
}