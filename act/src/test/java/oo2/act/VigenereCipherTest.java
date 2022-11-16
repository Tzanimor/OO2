package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VigenereCipherTest {

	public Cipher cipher;
	CipherBuilder builder;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		cipher = new Cipher();
	};
	@Test
	public void SimpleTest() {
		builder = cipher.constructVigenereCipher("pizza");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Iwcn tt laimqhaa dmtgi dn mk ppzbhaa x Fxvzk";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Vigenere
	};
	@Test
	public void MinimalTest() {
		builder = cipher.constructVigenereCipher("d");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Vigenere con letra como clave 
	};
	@Test
	public void EmptyTest() {
		builder = cipher.constructVigenereCipher("pizza");
		textDe = "";															textCi = "";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Vigenere vacio
	};
	@Test
	public void InputTest() {
		builder = cipher.constructVigenereCipher("pizza");
		assertThrows(IllegalArgumentException.class, () -> { builder.cipher("ñ"); });																// Vigenere texto fuera de alfabeto
		assertThrows(IllegalArgumentException.class, () -> { cipher.constructVigenereCipher(""); });												// Vigenere clave vacia
		assertThrows(IllegalArgumentException.class, () -> { cipher.constructVigenereCipher("ñ"); });												// Vigenere clave fuera de alfabeto
	};
}
