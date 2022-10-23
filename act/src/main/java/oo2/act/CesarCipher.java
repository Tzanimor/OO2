package oo2.act;

public class  CesarCipher extends SubsitutionCipher {
	
  private int jump;
  
  
  public CesarCipher(int number, String inputAlphabet){
	  setAlphabet(inputAlphabet);
	  setJump(number);
  };

  public CesarCipher(int number) {
	  setAlphabet("abcdefghijklmnopqrstuvwxyz");
      setJump(number);
  };

  public String cipher(String inputText) {
	  return super.cipher(inputText);
  }; 

  public String decipher(String inputText) {
	  return super.decipher(inputText); 
  }; 

  protected char cipherChar(char inputChar) {
	  if (inputChar == ' ') // Espacios se mantienen
		  return ' ';
      char result;
      int offset;
      int idx = java.util.Arrays.binarySearch(alphabet, Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto
      if (idx < 0)  // Comprueba si esta en el alfabeto, redundante
    	  throw new IllegalArgumentException("Character not available in alphabet");
	  offset = idx + jump;
      if (offset < alphabet.length)
          result = alphabet[offset];
      else
          result = alphabet[offset - alphabet.length];
      if (Character.isUpperCase(inputChar)) // Cambia a mayuscula si necesita
    	  result = Character.toUpperCase(result);
      return result;
  };

  protected char decipherChar(char inputChar) {
	  if (inputChar == ' ') // Espacios se mantienen
		  return ' ';
      int offset;
      char result;
      int idx = java.util.Arrays.binarySearch(alphabet, Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto
      if (idx < 0)  // Comprueba si esta en el alfabeto, redundante
    	  throw new IllegalArgumentException("Character not available in alphabet");
      offset = idx - jump;
      if(offset >= 0)
          result = alphabet[offset];
      else
          result = alphabet[ alphabet.length + offset];
      if (Character.isUpperCase(inputChar)) // Cambia a mayuscula si necesita
    	  result = Character.toUpperCase(result);
      return result;
  };
  
  public void setJump(int newJump) {
	  if (newJump < 0) 
		  this.jump = alphabet.length + (newJump % alphabet.length); // Elimina vueltas y arregla el negativo
	  else
		  this.jump = newJump % alphabet.length; // Elimina vueltas
  };
}