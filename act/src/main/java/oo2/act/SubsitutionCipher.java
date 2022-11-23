package oo2.act;

public class SubsitutionCipher implements Cipher {

	private char[] alphabet;
	private int[] jump;
	private int index = 0;
	

	public SubsitutionCipher(int number, String inputAlphabet) {
		setAlphabet(inputAlphabet);
		setJump(number);
	}

	public SubsitutionCipher(int number) {
		setAlphabet("abcdefghijklmnopqrstuvwxyz");
		setJump(number);
	}
	
	public SubsitutionCipher(String kword, String inputAlphabet) {
		setAlphabet(inputAlphabet);
		setKeyword(kword);
	}

	public SubsitutionCipher(String kword) {
		setAlphabet("abcdefghijklmnopqrstuvwxyz");
		setKeyword(kword);
	}
	
	public String cipher(String inputText) {
		reset();
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		for (int idx = 0; idx < inputChar.length; idx++)
			inputChar[idx] = cipherChar(inputChar[idx]); // Cifrando caracteres, implementacion especifica en hijos
		return new String(inputChar);
	}

	public String decipher(String inputText) {
		reset();
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		for (int idx = 0; idx < inputChar.length; idx++)
			inputChar[idx] = decipherChar(inputChar[idx]); // Decifrando caracteres, implementacion especifica en hijos
		return new String(inputChar);
	}

	private char cipherChar(char inputChar) {
		if (inputChar == ' ') { // Espacios se mantienen
			next(); // Salto extra que se come el espacio
			return ' ';
		}
		int offset = this.searchChar(inputChar) + this.currentOffset();
		char result = (offset < alphabet.length) ? alphabet[offset] : alphabet[offset - alphabet.length]; // Controla el salto
		return setCase(inputChar, result);
	}

	private char decipherChar(char inputChar) {
		if (inputChar == ' ') { // Espacios se mantienen
			next(); // Salto extra que se come el espacio
			return ' ';
		}
		int offset = this.searchChar(inputChar) - this.currentOffset();
		char result = (offset >= 0) ? alphabet[offset] : alphabet[alphabet.length + offset]; // Controla el salto
		return setCase(inputChar, result);
	}
	
	private int currentOffset() {
		return next();
	}

	private int searchChar(char inputChar) {
		int idx = java.util.Arrays.binarySearch(alphabet, Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto
		if (idx < 0)
			throw new IllegalArgumentException("Character not available in alphabet");
		return idx;
	}

	private char setCase(char inputChar, char result) {
		return (Character.isUpperCase(inputChar)) ? Character.toUpperCase(result) : result; // Cambia a mayuscula si necesita
	}
	
	public void setAlphabet(String inputAlphabet) {
		alphabet = inputAlphabet.toCharArray(); // Transformando cadena a arreglo de caracteres
	}
	
	public void setJump(int num) {		
		jump = new int[1];
		jump[0] = (num < 0) ? alphabet.length + (num % alphabet.length) : num % alphabet.length;
	}
	
	public void setKeyword(String inputText) {
		if (inputText.length() == 0) // Comprobando si la clave es al menos un caracterde largo
			throw new IllegalArgumentException("Keyword too short");
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		jump = new int[inputText.length()];
		for (int idx = 0; idx < inputText.length(); idx++)
			jump[idx] = searchChar(inputChar[idx]); // Comprobando si los caracteres de la clave son validos
	}
	
	public int next() {
		if (index >= jump.length)
			index = 0;
		return jump[index++];
	}

	public void reset() {
		index = 0;
	}
}