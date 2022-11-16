package oo2.act;

public abstract class SubsitutionCipher implements CipherBuilder {

	protected char[] alphabet;

	public String cipher(String inputText) {
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		for (int idx = 0; idx < inputChar.length; idx++)
			inputChar[idx] = cipherChar(inputChar[idx]); // Cifrando caracteres, implementacion especifica en hijos
		return new String(inputChar);
	}

	public String decipher(String inputText) {
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		for (int idx = 0; idx < inputChar.length; idx++)
			inputChar[idx] = decipherChar(inputChar[idx]); // Decifrando caracteres, implementacion especifica en hijos
		return new String(inputChar);
	}

	protected abstract char cipherChar(char inputChar);

	protected abstract char decipherChar(char inputChar);

	protected int searchChar(char inputChar) {
		int idx = java.util.Arrays.binarySearch(alphabet, Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto
		if (idx < 0)
			throw new IllegalArgumentException("Character not available in alphabet");
		return idx;
	}

	protected char setCase(char inputChar, char result) {
		return (Character.isUpperCase(inputChar)) ? Character.toUpperCase(result) : result; // Cambia a mayuscula si necesita
	}
	
	public void setAlphabet(String inputAlphabet) {
		alphabet = inputAlphabet.toCharArray(); // Transformando cadena a arreglo de caracteres
	}
}