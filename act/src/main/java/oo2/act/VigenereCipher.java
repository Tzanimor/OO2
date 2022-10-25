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
	  int offset = this.searchCaracter(inputChar) + this.currentOffset();
      char result = (offset < alphabet.length) ? alphabet[offset] : alphabet[offset - alphabet.length]; // Controla el salto
      return resultCase(inputChar, result);
  };

  protected char decipherChar(char inputChar) {
	  if (inputChar == ' ') { // Espacios se mantienen
		  keyword.next(); // Salto extra que se come el espacio
		  return ' ';
	  }
	  int offset = this.searchCaracter(inputChar) - this.currentOffset();
      char result = (offset >= 0) ? alphabet[offset] : alphabet[alphabet.length + offset]; // Controla el salto
      return resultCase(inputChar, result);
  };
  
  private int currentOffset(){
      return keyword.next() - alphabet[0];
  };
  
  public void setKeyword(String srcString) {
	  if (srcString.length() == 0) // Comprobando si la clave es al menos un caracterde largo
		  throw new IllegalArgumentException("Keyword too short");
	  char[] src = new char[srcString.length()]; // Transformando cadena a arreglo de caracteres
	  srcString.getChars(0,srcString.length(), src, 0);
	  for (int idx=0; idx < srcString.length(); idx++)
		  searchCaracter(src[idx]); // Comprobando si los caracteres de la clave son validos
	  keyword = new CharCircularBuffer(srcString);
  };
}