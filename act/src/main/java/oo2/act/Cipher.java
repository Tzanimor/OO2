package oo2.act;

public class Cipher {	

	public CipherBuilder constructCeasarCipher(int jumps) {
		return new CesarCipher(jumps);
	}
	
	public CipherBuilder constructCeasarCipher(int jumps, String alphabet) {
		return new CesarCipher(jumps, alphabet);
	}
	
	public CipherBuilder constructVigenereCipher(String kword) {
		return new VigenereCipher(kword);
	}
	
	public CipherBuilder constructVigenereCipher(String kword, String alphabet) {
		return new VigenereCipher(kword, alphabet);
	}
	
	public CipherBuilder constructRailFenceCipher(int railCount) {
		return new RailFenceCipher(railCount);
	}
	
	public CipherBuilder constructRouteCipher(int railCount) {
		return new RouteCipher(railCount);
	}
}