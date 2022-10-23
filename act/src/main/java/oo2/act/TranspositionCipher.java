package oo2.act;

public abstract class TranspositionCipher implements Cipher {
	
	protected BouncingIndex bIndex;
	protected int railCount;
	
	
	public String cipher(String inputText) {
		char inputChar[] = new char[inputText.length()]; // Transformando cadena a arreglo de caracteres
		inputText.getChars(0,inputText.length(), inputChar, 0);
		String[] rails = new String[railCount]; // Inicializando carriles
		for (int idx = 0; idx < rails.length; idx++)
			rails[idx]="";
		bIndex.reset(); // Limpia el indice de rebote
		for(int idx = 0; idx < inputText.length(); idx++) // Destribuir caracteres       
			rails[bIndex.next()]+=  inputChar[idx]; 
		String result = "";
		for(int idx = 0; idx < rails.length; idx++) // Unificar carriles
			result += rails[idx];
		return result; 
	};
	
	public String decipher(String inputText) {		
		String[] rails = recoverRails(inputText); // Recuperar carriles, implementacion especifica en hijos
		bIndex.reset(); // Limpia el indice de rebote
		String result = "";
		for(int idx = 0; idx < inputText.length(); idx++) { // Destribuir caracteres
			int pos = bIndex.next();
			char[] singleChar = new char[1];
			rails[pos].getChars(0, 1, singleChar, 0);
			rails[pos] = new StringBuilder(rails[pos]).deleteCharAt(0).toString();
			result+= singleChar[0];
		}
		return result;
	};
	
	protected abstract String[] recoverRails(String inputText);
	
	protected String takeRail(int pos, int amount, char inputChar[]) {
		String result = "";
		for (int idx = pos; idx < (pos + amount) ; idx++) 
			result+= inputChar[idx];
		return result;
	};
	
	public void setRailCount(int newRailCount) {
		if (newRailCount < 1) // Comprueba que sea 1 o mas
			throw new IllegalArgumentException("Rails need to set at least in 1");
		this.railCount = newRailCount;
		bIndex.setSize(newRailCount); // Se asegura actualizar siempre el indice de rebote
	};
}
