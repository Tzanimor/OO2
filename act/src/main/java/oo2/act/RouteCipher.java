package oo2.act;

public class RouteCipher extends TranspositionCipher {

	public RouteCipher(int railCount) {
		bIndex = new RouteBouncingIndex(); // Inicializacion de indice de rebote especifico
		setRailCount(railCount);
	};
	
	public String cipher(String inputText) {
		return super.cipher(inputText); 
	};

	public String decipher(String inputText) {
		return super.decipher(inputText);
	};
}
