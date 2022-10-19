package oo2.act;

public abstract class SubsitutionCipher implements Cipher {
	
	protected char[] alphabet;
	
	
	public String cipher(String inputText) {
		correctInput(inputText); // Comprobando si los caracteres del alfabeto son validos
	      char[] result = new char[inputText.length()];  // Transformando cadena a arreglo de caracteres
	      inputText.getChars(0, inputText.length(), result, 0);
	      for (int idx=0; idx < result.length; idx++)
	    	  result[idx] = cipherChar(result[idx]); // Cifrando caracteres, implementacion especifica en hijos
	      return new String(result);
	}
	
	public String decipher(String inputText) {
		correctInput(inputText); // Comprobando si los caracteres del alfabeto son validos
	      char[] result = new char[inputText.length()];  // Transformando cadena a arreglo de caracteres
	      inputText.getChars(0, inputText.length(), result, 0);
	      for (int idx=0; idx < result.length; idx++)
	    	  result[idx] = decipherChar(result[idx]); // Decifrando caracteres, implementacion especifica en hijos
	      return new String(result); 
	}
	
	protected abstract char cipherChar(char inputChar);
	
	protected abstract char decipherChar(char inputChar);
	
	protected void correctInput(String inputText) {
		char[] inputChar = new char[inputText.length()];  // Transformando cadena a arreglo de caracteres
		inputText.getChars(0,inputText.length(), inputChar, 0);
		for (int idx = 0; idx < inputText.length(); idx++)
			if (charNotAvailable(inputChar[idx])) // Comprueba si está en el alfabeto
				throw new IllegalArgumentException("Character not available in alphabet");
	};
	
	private boolean charNotAvailable(char c) {
		for (int idx=0; idx < alphabet.length; idx++)
			if (c == Character.toUpperCase(alphabet[idx]) || c == Character.toLowerCase(alphabet[idx]) || c == ' ') // Chequea si esta en mayuscula, minuscula o espacio
				return false;
		return true;
	}
	
	public void setAlphabet(String inputAlphabet) {
		char[] newAlphabet = new char[inputAlphabet.length()];
	    inputAlphabet.getChars(0,inputAlphabet.length(), newAlphabet, 0);
		alphabet = newAlphabet;
	}
}
