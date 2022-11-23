package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VigenereCipherTest {

	public CipherBuilder builder;
	public Cipher cipher;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		builder = new CipherBuilder();
	};
	@Test
	public void SimpleTest() {
		cipher = builder.constructVigenereCipher("pizza");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Iwcn tt laimqhaa dmtgi dn mk ppzbhaa x Fxvzk";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Vigenere
	};
	@Test
	public void MinimalTest() {
		cipher = builder.constructVigenereCipher("d");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Vigenere con letra como clave 
	};
	@Test
	public void EmptyTest() {
		cipher = builder.constructVigenereCipher("pizza");
		textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Vigenere vacio
	};
	@Test
	public void InputTest() {
		cipher = builder.constructVigenereCipher("pizza");
		assertThrows(IllegalArgumentException.class, () -> { cipher.cipher("ñ"); });																// Vigenere texto fuera de alfabeto
		assertThrows(IllegalArgumentException.class, () -> { builder.constructVigenereCipher(""); });												// Vigenere clave vacia
		assertThrows(IllegalArgumentException.class, () -> { builder.constructVigenereCipher("ñ"); });												// Vigenere clave fuera de alfabeto
	};
}
