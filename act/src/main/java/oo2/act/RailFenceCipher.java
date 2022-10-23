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
	
	protected String[] recoverRails(String inputText) {
		char inputChar[] = new char[inputText.length()]; // Transformando cadena a arreglo de caracteres
		inputText.getChars(0,inputText.length(), inputChar, 0);
		String[] rails = new String[railCount]; // Inicializando carriles
		int unit = (2 * railCount) - 2; // Bloque de posiciones iterable
		int remainder = inputText.length() % unit; // Posiciones que no llegan a completar el ciclo
		int extra; // Var temporal para sumar resto
		int cycles = inputText.length() / unit; // Ciclos que un bloque se repite en el texto
		if (remainder > 0) extra = 1; else extra = 0; // Calc resto
		rails[0] = takeRail(0, cycles + extra, inputChar); // Carril de cabecera
		int sum = cycles + extra; // Var temporal usado como indice
		for (int idx = 1; idx < (rails.length - 1) ; idx++) {  // Carriles de intermedios
			if (remainder >= ((railCount * 2) - idx)) extra = 2; else if (remainder > idx) extra = 1;  else extra = 0;// Calc resto
			rails[idx] = takeRail(sum, (cycles * 2) + extra, inputChar);
			sum+= (cycles * 2) + extra;
		}
		if (remainder >= railCount) extra = 1; else extra = 0; // Calc resto
		rails[rails.length - 1] = takeRail(sum, cycles + extra, inputChar);  // Carril pie
		return rails;
	};
}