package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VigenereCipherTest {

	public VigenereCipher vigenere;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	};
	@Test
	public void SimpleTest() {
		vigenere = new VigenereCipher("pizza");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Iwcn tt laimqhaa dmtgi dn mk ppzbhaa x Fxvzk";
		assertEquals(textCi, vigenere.cipher(textDe));							assertEquals(textDe, vigenere.decipher(textCi));					// Vigenere
	};
	@Test
	public void MinimalTest() {
		vigenere = new VigenereCipher("d");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, vigenere.cipher(textDe));							assertEquals(textDe, vigenere.decipher(textCi));					// Vigenere con letra como clave 
	};
	@Test
	public void EmptyTest() {
		vigenere = new VigenereCipher("d");		
		textDe = "";															textCi = "";
		assertEquals(textCi, vigenere.cipher(textDe));							assertEquals(textDe, vigenere.decipher(textCi));					// Vigenere vacio
	};
	@Test
	public void InputTest() {
		vigenere = new VigenereCipher("pizza");
		assertThrows(IllegalArgumentException.class, () -> { vigenere.cipher("ñ"); });																// Vigenere texto fuera de alfabeto
		assertThrows(IllegalArgumentException.class, () -> { new VigenereCipher(""); });															// Vigenere clave vacia
		assertThrows(IllegalArgumentException.class, () -> { new VigenereCipher("ñ"); });															// Vigenere clave fuera de alfabeto
	};
}
