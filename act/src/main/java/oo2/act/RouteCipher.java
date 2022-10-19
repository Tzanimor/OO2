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
	
	protected String[] recoverRails(String inputText) {
		char inputChar[] = new char[inputText.length()]; // Transformando cadena a arreglo de caracteres
		inputText.getChars(0,inputText.length(), inputChar, 0);
		String[] rails = new String[railCount]; // Inicializando carriles
		int unit =  railCount; // Bloque de posiciones iterable
		int remainder = inputText.length() % unit; // Posiciones que no llegan a completar el ciclo
		int extra; // Var temporal para sumar resto
		int cycles = inputText.length() / unit; // Ciclos que un bloque se repite en el texto
		int sum = 0; // Var temporal usado como indice
		for (int idx = 0; idx < rails.length ; idx++) {  // Recorrido de Carriles
			if (remainder > idx) extra = 1; else extra = 0;// Calc resto
			rails[idx] = takeRail(sum, cycles + extra, inputChar);
			sum+= cycles + extra;
		}
		return rails;
	}
}
