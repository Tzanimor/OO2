package oo2.act;

import java.util.Arrays;

public class TranspositionCipher implements Cipher {

	protected BouncingIndex bIndex;
	protected int railCount;
	
	public TranspositionCipher(BouncingIndex index, int railCount) {
		bIndex = index; // Inicializacion de indice de rebote especifico
		setRailCount(railCount);
	}

	public String cipher(String inputText) {
		if (railCount == 1) // Esta cosa me rompe todo
			return inputText;
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		String[] rails = new String[railCount]; // Inicializando carriles vacios
		for (int idx = 0; idx < rails.length; idx++)
			rails[idx] = "";
		bIndex.reset(); // Limpia el indice de rebote
		for (int idx = 0; idx < inputText.length(); idx++) // Destribuir caracteres
			rails[bIndex.next()] += inputChar[idx];
		String result = "";
		rails = bIndex.getOrder(rails);
		for (int idx = 0; idx < rails.length; idx++) // Unificar carriles
			result += rails[idx];
		return result;
	}

	public String decipher(String inputText) {
		if (railCount == 1) // Esta cosa me rompe todo
			return inputText;
		char[] inputChar = inputText.toCharArray(); // Transformando cadena a arreglo de caracteres
		bIndex.reset(); // Limpia el indice de rebote
		char[][] rails = new char[railCount][inputText.length()]; // Inicializando carriles marcando el camino
		for (int i = 0; i < inputText.length(); i++) {
			int pos = bIndex.next();
			rails[pos][i] = '@';
		}
		rails = bIndex.getOrder(rails);
		int j = 0;
		for (int k = 0; k < railCount; k++) { // Llenar matriz
			for (int l = 0; l < inputText.length(); l++) {
				if (rails[k][l] == '@') {
					rails[k][l] = inputChar[j];
					j++;
				}
				else
					rails[k][l] = '$';
			}
		}	
		bIndex.reset(); // Limpia el indice de rebote
		rails = bIndex.getOrder(rails);
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