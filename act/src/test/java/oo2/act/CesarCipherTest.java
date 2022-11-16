package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
	
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
		builder = cipher.constructCeasarCipher(3);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Cesar
	};
	@Test
	public void JumpTest() {
		builder = cipher.constructCeasarCipher(0);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Cesar sin salto
		
		builder = cipher.constructCeasarCipher(3 + (26*8));
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Cesar con vueltas
		
		builder = cipher.constructCeasarCipher(-23);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Cesar negativo
		
		textDe = "";															textCi = "";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Cesar vacio
	};
	@Test
	public void EmptyTest() {
		builder = cipher.constructCeasarCipher(0);
		textDe = "";															textCi = "";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Cesar vacio
	};
	@Test
	public void InputTest() {
		builder = cipher.constructCeasarCipher(3);
		assertThrows(IllegalArgumentException.class, () -> { builder.cipher("ñ"); });																// Cesar texto fuera de alfabeto
	};
}