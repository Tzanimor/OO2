package oo2.act;

public class RailFenceCipher extends TranspositionCipher {

	public RailFenceCipher(int railCount) {
		bIndex = new RailFenceBouncingIndex(); // Inicializacion de indice de rebote especifico
		setRailCount(railCount);
	};

	public String cipher(String inputText) {
		if (railCount == 1) // Esta cosa me rompe todo
			return inputText;
		return super.cipher(inputText); 
	};

	public String decipher(String inputText) {
		if (railCount == 1) // Esta cosa me rompe todo
			return inputText;
		return super.decipher(inputText); 
	};
}