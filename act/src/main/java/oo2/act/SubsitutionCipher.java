package oo2.act;

public abstract class SubsitutionCipher implements Cipher {
	
	protected char[] alphabet;
	
	
	public String cipher(String inputText) {
		char[] result = new char[inputText.length()]; // Transformando cadena a arreglo de caracteres
		inputText.getChars(0, inputText.length(), result, 0);
		for (int idx=0; idx < result.length; idx++)
			result[idx] = cipherChar(result[idx]); // Cifrando caracteres, implementacion especifica en hijos
		return new String(result);
	};
	
	public String decipher(String inputText) {
	    char[] result = new char[inputText.length()];  // Transformando cadena a arreglo de caracteres
	    inputText.getChars(0, inputText.length(), result, 0);
	    for (int idx=0; idx < result.length; idx++)
	    	result[idx] = decipherChar(result[idx]); // Decifrando caracteres, implementacion especifica en hijos
	    return new String(result); 
	};
	
	protected abstract char cipherChar(char inputChar);
	
	protected abstract char decipherChar(char inputChar);
	
	protected int searchCaracter(char inputChar) {
		int idx = java.util.Arrays.binarySearch(alphabet, Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto
		if (idx < 0)
			throw new IllegalArgumentException("Character not available in alphabet");
		return idx ;
	};
	
	public void setAlphabet(String inputAlphabet) {
		char[] newAlphabet = new char[inputAlphabet.length()]; // Transformando cadena a arreglo de caracteres
	    inputAlphabet.getChars(0,inputAlphabet.length(), newAlphabet, 0);
		alphabet = newAlphabet;
	};
	
	protected char resultCase(char inputChar, char result) {
		return (Character.isUpperCase(inputChar)) ? Character.toUpperCase(result) : result; // Cambia a mayuscula si necesita
	};
}