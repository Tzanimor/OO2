package oo2.act;

public abstract class TranspositionCipher implements CipherBuilder {

	protected BouncingIndex bIndex;
	protected int railCount;

	public String cipher(String inputText) {
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		String[] rails = new String[railCount]; // Inicializando carriles vacios
		for (int idx = 0; idx < rails.length; idx++)
			rails[idx] = "";
		bIndex.reset(); // Limpia el indice de rebote
		for (int idx = 0; idx < inputText.length(); idx++) // Destribuir caracteres
			rails[bIndex.next()] += inputChar[idx];
		String result = "";
		for (int idx = 0; idx < rails.length; idx++) // Unificar carriles
			result += rails[idx];
		return result;
	}

	public String decipher(String inputText) {
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		bIndex.reset(); // Limpia el indice de rebote
		char[][] rails = new char[railCount][inputText.length()]; // Inicializando carriles marcando el camino
		for (int i = 0; i < inputText.length(); i++) {
			int pos = bIndex.next();
			rails[pos][i] = '@';
		}
		int j = 0;
		for (int k = 0; k < railCount; k++) { // Llenar matriz
			for (int l = 0; l < inputText.length(); l++) {
				if (rails[k][l] == '@') {
					rails[k][l] = inputChar[j];
					j++;
				}
			}
		}
		bIndex.reset(); // Limpia el indice de rebote
		String result = "";
		for (int m = 0; m < inputText.length(); m++) { // Recorrer camino
			int pos = bIndex.next();
			result += rails[pos][m];
		}
		return result;
	}

	public void setRailCount(int newRailCount) {
		if (newRailCount < 1) // Comprueba que sea 1 o mas
			throw new IllegalArgumentException("Rails need to set at least in 1");
		this.railCount = newRailCount;
		bIndex.setSize(newRailCount); // Se asegura actualizar siempre el indice de rebote
	}
}