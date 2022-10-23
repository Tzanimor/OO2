package oo2.act;

public class VigenereCipher extends SubsitutionCipher {

  private CharCircularBuffer keyword;
  
  
  public  VigenereCipher(String inputAlphabet, String kword) {
	  setAlphabet(inputAlphabet);
      setKeyword(kword);
  };

  public  VigenereCipher(String kword) {
	  setAlphabet("abcdefghijklmnopqrstuvwxyz");
      setKeyword(kword);
  };

  public String cipher(String inputText) {
	  keyword.reset(); // Limpiar indice      
      return super.cipher(inputText);
  }; 

  public String decipher(String inputText) {
	  keyword.reset(); // Limpiar indice      
      return super.decipher(inputText);
  };
  
  protected char cipherChar(char inputChar) {
	  if (inputChar == ' ') { // Espacios se mantienen
		  keyword.next(); // Salto extra que se come el espacio
		  return ' ';
	  }
	  int idx = java.util.Arrays.binarySearch(alphabet,Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto 
	  if (idx < 0)  // Comprobando si esta en el alfabeto, redundante
    	  throw new IllegalArgumentException("Character not available in alphabet");
	  int offset;
      char result;
	  offset = idx + this.currentOffset(); // Suma posicion char a cifrar (idx) y posicion char clave (currentOffset)
      if (offset < alphabet.length)
          result = alphabet[offset];
      else
          result = alphabet[offset - alphabet.length];
      if (Character.isUpperCase(inputChar)) // Cambia a mayuscula si necesita
    	  result = Character.toUpperCase(result);
      return result;
  };

  protected char decipherChar(char inputChar) {
	  if (inputChar == ' ') { // Espacios se mantienen
		  keyword.next(); // Salto extra que se come el espacio
		  return ' ';
	  }
	  int idx = java.util.Arrays.binarySearch(alphabet,Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto 
	  if (idx < 0)  // Comprobando si esta en el alfabeto, redundante
    	  throw new IllegalArgumentException("Character not available in alphabet");
	  int offset;
      char result;
      offset = idx - this.currentOffset();
      if (offset >= 0)
          result = alphabet[offset];
      else
          result = alphabet[alphabet.length + offset];
      if (Character.isUpperCase(inputChar)) // Cambia a mayuscula si necesita
    	  result = Character.toUpperCase(result);
      return result;
  };
  
  private int currentOffset(){
      return keyword.next() - alphabet[0];
  };
  
  public void setKeyword(String srcString) {
	  if (srcString.length() == 0) // Comprobando si la clave es al menos un caracterde largo
		  throw new IllegalArgumentException("Keyword too short");
	  correctInput(srcString); // Comprobando si los caracteres de la clave son validos
      keyword = new CharCircularBuffer(srcString);
  };
}
