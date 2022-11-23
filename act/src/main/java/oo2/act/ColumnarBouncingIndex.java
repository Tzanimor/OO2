package oo2.act;

public class ColumnarBouncingIndex extends BouncingIndex {
	
	private int[] order;
	private char[] alphabet;
	

	public ColumnarBouncingIndex(String kword) {
		alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // Transformando cadena a arreglo de caracteres
		setOrder(kword);
		index = 0;
	}

	public int next() {
		int result = index;
		if (index < maxSize)
			index++;
		else
			index = 0;
		return result;
	}
	@Override
	public String[] getOrder(String[] rails) {
		String[] newRails = new String[rails.length];
		for (int idx = 0; idx < rails.length; idx++)
			newRails[idx] = rails[order[idx]]; // Reorganizacion
		return newRails;
	}
	@Override
	public char[][] getOrder(char[][] rails) {
		char[][] newRails = new char[rails.length][];
		for (int idx = 0; idx < rails.length; idx++)
			newRails[idx] = rails[order[idx]]; // Reorganizacion
		return newRails;
	}
	
	private void setOrder(String inputText) {
		if (inputText.length() == 0) // Comprobando si la clave es al menos un caracter de largo
			throw new IllegalArgumentException("Keyword too short");
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		int[] aux = new int[inputText.length()];
		for (int idx = 0; idx < inputText.length(); idx++) {
			aux[idx] = searchChar(inputChar[idx]); // Comprobando si los caracteres de la clave son validos
		}
		order = new int[inputText.length()];
		for (int x = 0; x < inputText.length(); x++) { // Ordenando de alfabeticamente
			int temp = 999;
			int pos = -1;
			for (int y = 0; y < inputText.length(); y++) {
				if (aux[y] < temp) {
					temp = aux[y];
					pos = y;
				}
			}
			order[pos] = x;
			aux[pos] = 999;
		}
	}
	
	private int searchChar(char inputChar) {
		int idx = java.util.Arrays.binarySearch(alphabet, Character.toLowerCase(inputChar)); // Busca caracter en minuscula en alfabeto
		if (idx < 0)
			throw new IllegalArgumentException("Character not available in alphabet");
		return idx;
	}
}