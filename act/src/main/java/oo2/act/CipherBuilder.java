package oo2.act;

public class CipherBuilder {	

	public Cipher constructCeasarCipher(int jumps) {
		return new SubsitutionCipher(jumps);
	}
	
	public Cipher constructCeasarCipher(int jumps, String alphabet) {
		return new SubsitutionCipher(jumps, alphabet);
	}
	
	public Cipher constructVigenereCipher(String kword) {
		return new SubsitutionCipher(kword);
	}
	
	public Cipher constructVigenereCipher(String kword, String alphabet) {
		return new SubsitutionCipher(kword, alphabet);
	}
	
	public Cipher constructRailFenceCipher(int railCount) {
		return new TranspositionCipher(new RailFenceBouncingIndex(), railCount);
	}
	
	public Cipher constructRouteCipher(int railCount) {
		return new TranspositionCipher(new RouteBouncingIndex(), railCount);
	}
	
	public Cipher constructColumnarCipher(String kword) {
		return new TranspositionCipher(new ColumnarBouncingIndex(kword), kword.length());
	}
}